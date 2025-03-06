package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.BooksRepository;
import it.sevenbits.courses.springbootexample.core.repository.games.IGamesRepository;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;
import it.sevenbits.courses.springbootexample.core.repository.questionsets.IQuestionSetsRepository;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;
import it.sevenbits.courses.springbootexample.core.service.answers.AnswersService;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.books.BooksService;
import it.sevenbits.courses.springbootexample.core.service.books.IBooksService;
import it.sevenbits.courses.springbootexample.core.service.games.GamesService;
import it.sevenbits.courses.springbootexample.core.service.games.IGamesService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questions.QuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.QuestionSetsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.IRoomsService;
import it.sevenbits.courses.springbootexample.core.service.rooms.RoomsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Service configuration
 */
@Configuration
public class ServiceConfig {

     /**
     * The method creates instance of service
     * @param booksRepository instance of the repository
     * @return instance of the service
     */
    @Bean
    public IBooksService booksService(final BooksRepository booksRepository) {
        return new BooksService(booksRepository);
    }

    /**
     * The method creates instance of service
     * @param answersRepository instance of the repository
     * @return instance of the service
     */
    @Bean
    public IAnswersService answersService(final IAnswersRepository answersRepository) {
        return new AnswersService(answersRepository);
    }

    /**
     * The method creates instance of service
     * @param gamesRepository instance of the repository
     * @param questionSetsService instance of the service
     * @return instance of the service
     */
    @Bean
    public IGamesService gamesService(final IGamesRepository gamesRepository, final IQuestionSetsService questionSetsService) {
        return new GamesService(gamesRepository, questionSetsService);
    }

    /**
     * The method creates instance of service
     * @param roomsRepository instance of the repository
     * @return instance of the service
     */
    @Bean
    public IRoomsService roomsService(final IRoomsRepository roomsRepository) {
        return new RoomsService(roomsRepository);
    }

    /**
     * The method creates instance of service
     * @param questionsRepository instance of the repository
     * @return instance of the service
     */
    @Bean
    public IQuestionsService questionsService(final IQuestionsRepository questionsRepository) {
        return new QuestionsService(questionsRepository);
    }

    /**
     * The method creates instance of service
     * @param questionSetsRepository instance of the repository
     * @return instance of the service
     */
    @Bean
    public IQuestionSetsService questionSetsService(final IQuestionSetsRepository questionSetsRepository) {
        return new QuestionSetsService(questionSetsRepository);
    }
}
