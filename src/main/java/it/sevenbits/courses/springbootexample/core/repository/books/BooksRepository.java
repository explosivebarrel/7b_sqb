package it.sevenbits.courses.springbootexample.core.repository.books;


import it.sevenbits.courses.springbootexample.core.model.books.Book;

import java.util.List;

/**
 * Interface for work with books repository
 *
 */
public interface BooksRepository {

    /**
     * This method searches for a books
     *
     * @return list of books
     */
    List<Book> getAllBooks();

    /**
     * Method receives a book by id
     *
     * @param id unique identifier from Database
     * @return instance of the book
     */
    Book getBookById(String id);


    /**
     * Method saves book in the repo
     *
     * @param book is a book to save
     * @return instance of the book
     */
    Book createBook(Book book);
}
