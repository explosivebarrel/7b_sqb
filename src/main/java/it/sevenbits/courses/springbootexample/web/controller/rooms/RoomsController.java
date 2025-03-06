package it.sevenbits.courses.springbootexample.web.controller.rooms;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questions.QuestionAnswerRequest;
import it.sevenbits.courses.springbootexample.core.model.questions.QuestionAnswerResponse;
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

    @PostMapping(value = "/{id}/game/start")
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

            curRoom.setCurrentGameId(curGame.getId());
            roomsService.save(curRoom);

            Question qs = questionsService.findById(curGame.getQuestionIterator().next());

            List<Answer> answs = new ArrayList<>(qs.getAllAnswerIDs().size());
            for (var a: qs.getAllAnswerIDs()) {
                answs.add(answersService.findById(a));
            }
            QuestionWithOptionsResponse ans = new QuestionWithOptionsResponse(qs.getId(), qs.getText(), answs);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/game")
    @ResponseBody
    public ResponseEntity<Game> getRoomsGame(
            @PathVariable(name = "id") final String id) {
        try {
            Room curRoom = roomsService.findById(UUID.fromString(id));

            if (curRoom.getCurrentGameId() == null) {
                throw new NullPointerException("No game currently running in " + id + " room");
            }

            Game curGame = gamesService.findById(curRoom.getCurrentGameId());

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(curGame);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}/game/question/{questionId}")
    @ResponseBody
    public ResponseEntity<QuestionWithOptionsResponse> getRoomGamesQuestionById(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "questionId") final String questionId) {
        try {
            Room curRoom = roomsService.findById(UUID.fromString(id));
            Game curGame = gamesService.findById(curRoom.getCurrentGameId());

            UUID qsId = UUID.fromString(questionId);

            Question qs;

            if (curGame.getQuestions().getQuestionIDs().contains(qsId)) {
                qs = questionsService.findById(qsId);
            } else {
                throw new IllegalArgumentException("Question " + questionId + " doesn't exists in this game");
            }

            List<Answer> answs = new ArrayList<>(qs.getAllAnswerIDs().size());
            for (var a: qs.getAllAnswerIDs()) {
                answs.add(answersService.findById(a));
            }

            QuestionWithOptionsResponse ans = new QuestionWithOptionsResponse(qs.getId(), qs.getText(), answs);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "/{id}/game/question/{questionId}/answer")
    @ResponseBody
    public ResponseEntity<QuestionAnswerResponse> getRoomGamesQuestionsAnswerById(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "questionId") final String questionId,
            @RequestBody QuestionAnswerRequest questionAnswerRequest) {
        try {
            Room curRoom = roomsService.findById(UUID.fromString(id));
            Game curGame = gamesService.findById(curRoom.getCurrentGameId());

            UUID qsId = UUID.fromString(questionId);

            Question qs;
            QuestionAnswerResponse ans;

            if (curGame.getQuestions().getQuestionIDs().contains(qsId)) {
                qs = questionsService.findById(qsId);
            } else {
                throw new IllegalArgumentException("Question " + questionId + " doesn't exists in this game");
            }

            if (questionAnswerRequest != null) {
                System.out.println(questionAnswerRequest.getAnswerId());
                System.out.println(qs.getCorrectAnswerID());
                System.out.println(questionAnswerRequest.getAnswerId().equals(qs.getCorrectAnswerID()));

                long scoreTotal = 0, scoreGain = 0;
                if (qs.getCorrectAnswerID().equals(questionAnswerRequest.getAnswerId())) {
                    scoreGain = 1;
                }
                scoreTotal += scoreGain;

                int nextIndex = curGame.getQuestions().getQuestionIDs().indexOf(qsId) + 1;
                UUID nextQuestionId = null;
                if (nextIndex < curGame.getQuestions().getQuestionIDs().size()) {
                    nextQuestionId = curGame.getQuestions().getQuestionIDs().get(nextIndex);
                }

                ans = new QuestionAnswerResponse(qs.getCorrectAnswerID(), nextQuestionId, scoreTotal, scoreGain);
            } else {
                throw new IllegalArgumentException("No request body sent!");
            }

            System.out.println("Response assembled: " + ans);

            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch(NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getCause() + "\n" + e.getMessage());
            return ResponseEntity.notFound().build();
        } catch(Exception e) {
            System.out.println(e.getCause() + "\n" + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
