package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.games.Game;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerRequest;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionAnswerResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionIdResponse;
import it.sevenbits.courses.springbootexample.web.model.questions.QuestionWithOptionsResponse;

import java.util.List;
/**
 *
 */
public interface IRoomsService {
    /**
     *
     * @return return
     */
    List<Room> getAll();
    // Room findById(UUID id);

    /**
     *
     * @param id id
     * @return return
     */
    Room findById(String id);

    /**
     *
     * @param answer answer
     * @return return
     */
    Room save(Room answer);

    /**
     *
     * @param id id
     * @param questionSetId qsid
     * @return rt
     */
    QuestionIdResponse startNewGameNGetQuestion(final String id, final String questionSetId);

    /**
     *
     * @param id id
     * @return rt
     */
    Game getRoomsGame(final String id);

    /**
     *
     * @param id id
     * @param questionId qsid
     * @return rt
     */
    QuestionWithOptionsResponse getRoomGamesQuestionById(final String id, final String questionId);

    /**
     *
     * @param id id
     * @param questionId qsid
     * @param questionAnswerRequest qsaq
     * @return rt
     */
    QuestionAnswerResponse getRoomGamesQuestionsAnswerById(
            final String id,
            final String questionId,
            final QuestionAnswerRequest questionAnswerRequest);
}
