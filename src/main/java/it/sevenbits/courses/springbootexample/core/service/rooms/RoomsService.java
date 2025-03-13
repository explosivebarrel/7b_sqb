package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerRequest;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionIdResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionWithOptionsResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
public class RoomsService implements IRoomsService {
    private final IRoomsRepository roomsRepository;
    private final IGamesService gamesService;
    private final IQuestionsService questionsService;
    private final IAnswersService answersService;
    private final IQuestionSetsService questionSetsService;

    /**
     *
     * @param roomsRepository repo
     * @param gamesService gs
     * @param questionsService qs
     * @param answersService as
     * @param questionSetsService qss
     */
    public RoomsService(final IRoomsRepository roomsRepository,
                        final IGamesService gamesService,
                        final IQuestionsService questionsService,
                        final IAnswersService answersService,
                        final IQuestionSetsService questionSetsService) {
        this.roomsRepository = roomsRepository;
        this.gamesService = gamesService;
        this.questionsService = questionsService;
        this.answersService = answersService;
        this.questionSetsService = questionSetsService;
    }

    /**
     *
     * @return return
     */
    @Override
    public List<Room> getAll() {
        return roomsRepository.getAll();
    }

    /**
     *
     * @param id id
     * @return return
     */
    @Override
    public Room findById(final String id) {
        return roomsRepository.findById(id);
    }

    /**
     *
     * @param answer answer
     * @return return
     */
    @Override
    public Room save(final Room answer) {
        return roomsRepository.save(answer);
    }

    /**
     *
     * @param id id
     * @param questionSetId qsid
     * @return rt
     */
    @Override
    public QuestionIdResponse startNewGameNGetQuestion(final String id, final String questionSetId) {
        // Room curRoom = roomsService.findById(UUID.fromString(id));
        Room curRoom = findById(id);
        Game curGame;

        if (questionSetId != null) {
            curGame = gamesService.startNewGame(UUID.fromString(questionSetId));
        } else {
            List<QuestionSet> qslist = questionSetsService.getAll();
            curGame = gamesService.startNewGame(qslist.get(0).getId());
        }

        curRoom.setCurrentGameId(curGame.getId());
        save(curRoom);

        return new QuestionIdResponse(curGame.getQuestions().getQuestionIDs().get(0));
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Game getRoomsGame(final String id) {
        //Room curRoom = roomsService.findById(UUID.fromString(id));
        Room curRoom = findById(id);

        if (curRoom.getCurrentGameId() == null) {
            throw new NullPointerException("No game currently running in " + id + " room");
        }

        return gamesService.findById(curRoom.getCurrentGameId());
    }

    /**
     *
     * @param id id
     * @param questionId qsid
     * @return rt
     */
    @Override
    public QuestionWithOptionsResponse getRoomGamesQuestionById(final String id, final String questionId) {
        // Room curRoom = roomsService.findById(UUID.fromString(id));
        Room curRoom = findById(id);
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

        return new QuestionWithOptionsResponse(qs.getId(), qs.getText(), answs);
    }

    /**
     *
     * @param id id
     * @param questionId qsid
     * @param questionAnswerRequest qsaq
     * @return rt
     */
    @Override
    public QuestionAnswerResponse getRoomGamesQuestionsAnswerById(
            final String id,
            final String questionId,
            final QuestionAnswerRequest questionAnswerRequest) {
        // Room curRoom = roomsService.findById(UUID.fromString(id));
        Room curRoom = findById(id);
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

        return ans;
    }
}
