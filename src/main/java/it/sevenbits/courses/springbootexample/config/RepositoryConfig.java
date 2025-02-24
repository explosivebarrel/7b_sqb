package it.sevenbits.courses.springbootexample.config;

import it.sevenbits.courses.springbootexample.core.repository.answers.IAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.answers.SimpleAnswersRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.BooksRepository;
import it.sevenbits.courses.springbootexample.core.repository.books.SimpleBooksRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class with configuration of repository
 */
@Configuration
public class RepositoryConfig {

    /**
     * The method creates instance of books repository
     * @return instance of the books repository
     */
    @Bean
    public BooksRepository booksRepository() {
        return new SimpleBooksRepository();
    }

    @Bean
    public IAnswersRepository answersRepository() {
        return new SimpleAnswersRepository();
    }
}