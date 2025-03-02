package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
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
     * The method creates instance of books service
     *
     * @param booksRepository instance of the books repository
     * @return instance of the books service
     */
    @Bean
    public IBooksService booksService(final BooksRepository booksRepository) {
        return new BooksService(booksRepository);
    }

    @Bean
    public IAnswersService answersService(final IAnswersRepository answersRepository) {
        return new AnswersService(answersRepository);
    }

    @Bean
    public IGamesService gamesService(final IGamesRepository gamesRepository, final IQuestionSetsService questionSetsService) {
        return new GamesService(gamesRepository, questionSetsService);
    }

    @Bean
    public IRoomsService roomsService(final IRoomsRepository roomsRepository) {
        return new RoomsService(roomsRepository);
    }

    @Bean
    public IQuestionsService questionsService(final IQuestionsRepository questionsRepository) {
        return new QuestionsService(questionsRepository);
    }

    @Bean
    public IQuestionSetsService questionSetsService(final IQuestionSetsRepository questionSetsRepository) {
        return new QuestionSetsService(questionSetsRepository);
    }
}
