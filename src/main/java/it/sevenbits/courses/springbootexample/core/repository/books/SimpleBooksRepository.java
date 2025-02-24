package it.sevenbits.courses.springbootexample.core.repository.books;


import it.sevenbits.courses.springbootexample.core.model.books.Book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.UUID;


/**
 * Database books repository - implementation of BooksRepository
 *
 */
public class SimpleBooksRepository implements BooksRepository {
    private final Map<String, Book> books = new HashMap<>();

    @Override
    public List<Book> getAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public Book getBookById(final String id) {
        return books.get(id);
    }

    @Override
    public Book createBook(final Book book) {
        String id = getNextID();
        Book newBook = new Book(id, book.getBookName(), book.getAuthor());
        books.put(id, newBook);
        return newBook;
    }

    private String getNextID() {
        return UUID.randomUUID().toString();
    }


}
