package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.BooksRepository;
import it.sevenbits.courses.springbootexample.core.service.answers.AnswersService;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.books.BooksService;
import it.sevenbits.courses.springbootexample.core.service.books.IBooksService;
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
}
