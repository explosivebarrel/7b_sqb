package it.sevenbits.courses.springbootexample.web.controller.books;

import it.sevenbits.courses.springbootexample.core.model.books.Book;
import it.sevenbits.courses.springbootexample.core.service.books.IBooksService;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Controller for the books
 *
 */
@Controller
@RequestMapping("/books")
public class BooksController {
    private final IBooksService booksService;

    /**
     * Basic constructor
     * @param booksService books service
     */
    public BooksController(final IBooksService booksService) {
        this.booksService = booksService;
    }

    /**
     * This method returns all existing books
     * @return response entity with books list
     */
    @GetMapping
    @ResponseBody
    public ResponseEntity<List<Book>> getAllBooks() {
        try {
            List<Book> books = booksService.getAllBooks();
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(books);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method returns the book by id
     * @param id unique identifier of book
     * @return response entity with book
     */
    @GetMapping(value = "/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookById(@PathVariable("id") final String id) {
        try {
            Book book = booksService.getBookById(id);
            return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(book);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Method creates book by passed data
     * @param newBook is data for creating new book
     * @return ResponseEntity with data and location
     */
    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Book> create(@RequestBody final Book newBook) {
        Book createdBook = booksService.createBook(newBook);
        URI location = UriComponentsBuilder
                .fromPath("/books/")
                .path(String.valueOf(createdBook.getBookId()))
                .build()
                .toUri();
        return ResponseEntity.created(location).body(createdBook);
    }
}
