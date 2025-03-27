package it.sevenbits.courses.springbootexample.web.controller.rooms;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionIdResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerRequest;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionWithOptionsResponse;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.IRoomsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

/**
 *
 */
@Controller
@RequestMapping("/rooms")
public class RoomsController {
    private final IRoomsService roomsService;
    private final IGamesService gamesService;
    private final IQuestionsService questionsService;
    private final IQuestionSetsService questionSetsService;
    private final IAnswersService answersService;

    /**
     *
     * @param roomsService roomsService
     * @param gamesService gamesService
     * @param questionsService questionsService
     * @param questionSetsService questionSetsService
     * @param answersService answersService
     */
    public RoomsController(final IRoomsService roomsService,
                           final IGamesService gamesService,
                           final IQuestionsService questionsService,
                           final IQuestionSetsService questionSetsService,
                           final IAnswersService answersService) {
        this.roomsService = roomsService;
        this.gamesService = gamesService;
        this.questionsService = questionsService;
        this.questionSetsService = questionSetsService;
        this.answersService = answersService;
    }

    /**
     *
     * @return return
     */
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

    /**
     *
     * @param id id
     * @return return
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Room> getRoom(@PathVariable("id") final String id) {
        try {
            Room ans = roomsService.findById(id);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id id
     * @param questionSetId questionSetId
     * @return return
     */
    @PostMapping(value = "/{id}/game/start")
    @ResponseBody
    public ResponseEntity<QuestionIdResponse> startNewGameNGetQuestion(
            @PathVariable(name = "id") final String id,
            @RequestParam(name = "questionSetId", required = false) final String questionSetId) {
        try {
            if (id.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (roomsService.findById(id) == null) {
                throw new IndexOutOfBoundsException();
            }
            QuestionIdResponse ans = roomsService.startNewGameNGetQuestion(id, questionSetId);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id id
     * @return return
     */
    @GetMapping(value = "/{id}/game")
    @ResponseBody
    public ResponseEntity<Game> getRoomsGame(@PathVariable(name = "id") final String id) {
        try {
            Game curGame = roomsService.getRoomsGame(id);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(curGame);
        } catch (NullPointerException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id id
     * @param questionId questionId
     * @return return
     */
    @GetMapping(value = "/{id}/game/question/{questionId}")
    @ResponseBody
    public ResponseEntity<QuestionWithOptionsResponse> getRoomGamesQuestionById(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "questionId") final String questionId) {
        try {
            if (id.isEmpty() || questionId.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (roomsService.findById(id) == null || questionsService.findById(UUID.fromString(questionId)) == null) {
                throw new IndexOutOfBoundsException();
            }
            QuestionWithOptionsResponse ans = roomsService.getRoomGamesQuestionById(id, questionId);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     *
     * @param id id
     * @param questionId questionId
     * @param questionAnswerRequest questionAnswerRequest
     * @return return
     */
    @PostMapping(value = "/{id}/game/question/{questionId}/answer")
    @ResponseBody
    public ResponseEntity<QuestionAnswerResponse> getRoomGamesQuestionsAnswerById(
            @PathVariable(name = "id") final String id,
            @PathVariable(name = "questionId") final String questionId,
            @RequestBody final QuestionAnswerRequest questionAnswerRequest) {
        try {
            if (id.isEmpty() || questionId.isEmpty()) {
                throw new IllegalArgumentException();
            }
            if (roomsService.findById(id) == null || questionsService.findById(UUID.fromString(questionId)) == null) {
                throw new IndexOutOfBoundsException();
            }
            if (questionAnswerRequest != null) {
                var l = questionsService.findById(UUID.fromString(questionId)).getAllAnswerIDs();
                if (!l.contains(questionAnswerRequest.getAnswerId())) {
                    System.out.println("Ans " + questionAnswerRequest + ": " + questionAnswerRequest.getAnswerId());
                    for (var a: l) {
                        System.out.println(a);
                    }

                    throw new NullPointerException();
                }
            } else {
                throw new IllegalArgumentException();
            }
            QuestionAnswerResponse ans = roomsService.getRoomGamesQuestionsAnswerById(id, questionId, questionAnswerRequest);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(ans);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (IndexOutOfBoundsException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (NullPointerException e) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
