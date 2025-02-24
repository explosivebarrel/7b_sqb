package it.sevenbits.courses.springbootexample.core.service.books;

import it.sevenbits.courses.springbootexample.core.model.books.Book;
import it.sevenbits.courses.springbootexample.core.repository.books.BooksRepository;

import java.util.List;

/**
 * This is service for a book entity
 */
public class BooksService implements IBooksService {
    private final BooksRepository booksRepository;

    /**
     * The basic constructor
     * @param booksRepository - books repository
     */
    public BooksService(final BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        return booksRepository.getAllBooks();
    }

    @Override
    public Book getBookById(final String id) {
        return booksRepository.getBookById(id);
    }

    @Override
    public Book createBook(final Book newBook) {
        return booksRepository.createBook(newBook);
    }
}
