package it.sevenbits.courses.springbootexample.core.model.books;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

/**
 * Model for a book
 *
 */
public class Book {
    private String id;
    private String bookName;
    private String author;

    /**
     * The basic constructor
     *
     * @param id - unique identifier from Database
     * @param bookName - book name
     * @param author - book author
     */
    @JsonCreator
    public Book(
            @JsonProperty("id") final String id,
            @JsonProperty("bookName") final String bookName,
            @JsonProperty("author") final String author
    ) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
    }

    public String getBookId() {
        return id;
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book that = (Book) o;
        return Objects.equals(bookName, that.bookName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookName);
    }
}
