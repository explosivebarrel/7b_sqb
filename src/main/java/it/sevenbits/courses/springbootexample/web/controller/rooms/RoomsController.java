package it.sevenbits.courses.springbootexample.web.controller.rooms;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questions.QuestionWithOptionsResponse;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questions.QuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.IRoomsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/rooms")
public class RoomsController {
    private IRoomsService roomsService;
    private IGamesService gamesService;
    private IQuestionsService questionsService;
    private IQuestionSetsService questionSetsService;
    private IAnswersService answersService;

    public RoomsController(IRoomsService roomsService, IGamesService gamesService, IQuestionsService questionsService, IQuestionSetsService questionSetsService, IAnswersService answersService) {
        this.roomsService = roomsService;
        this.gamesService = gamesService;
        this.questionsService = questionsService;
        this.questionSetsService = questionSetsService;
        this.answersService = answersService;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Room>> getAllRooms() {
        try {
            List<Room> ans = roomsService.getAll();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Room> getRoom(@PathVariable("id") final String id) {
        try {
            Room ans = roomsService.findById(UUID.fromString(id));
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/game/start")
    @ResponseBody
    public ResponseEntity<QuestionWithOptionsResponse> startNewGameNGetQuestion(
            @PathVariable(name = "id") final String id,
            @RequestParam(name = "questionSetId", required = false) final String questionSetId) {
        try {
            Room curRoom = roomsService.findById(UUID.fromString(id));
            Game curGame;
            if (questionSetId != null) {
                curGame = gamesService.startNewGame(UUID.fromString(questionSetId));
            } else {
                List<QuestionSet> qslist = questionSetsService.getAll();
                curGame = gamesService.startNewGame(qslist.get(0).getId());
            }

            Question qs = questionsService.findById(curGame.getQuestionIterator().next());
            List<Answer> answs = new ArrayList<>(qs.getAllAnswerIDs().size()+1);
            for (var a: qs.getIncorrectAnswerIDs()) {
                answs.add(answersService.findById(a));
            }
            answs.add(answersService.findById(qs.getCorrectAnswerID()));

            QuestionWithOptionsResponse ans = new QuestionWithOptionsResponse(qs.getId(), qs.getText(), answs);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
