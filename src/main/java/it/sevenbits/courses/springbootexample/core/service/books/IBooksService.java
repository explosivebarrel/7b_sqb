package it.sevenbits.courses.springbootexample.core.service.books;

import it.sevenbits.courses.springbootexample.core.model.books.Book;

import java.util.List;

/**
 * Interface for work with books service
 */
public interface IBooksService {

    /**
     * This method returns all existing books
     * @return list of books
     */
    List<Book> getAllBooks();

    /**
     * Method returns the book by id
     * @param id unique identifier from Database
     * @return instance of the book
     */
    Book getBookById(String id);

    /**
     * Method creates the book
     *
     * @param newBook is data of book to create
     * @return instance of the book
     */
    Book createBook(Book newBook);
}
