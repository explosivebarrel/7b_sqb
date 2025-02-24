package it.sevenbits.courses.springbootexample.core.model.answers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

public class Answer {
    private UUID id;
    private String text;

    @JsonCreator
    public Answer(@JsonProperty("text") final String text) {
        this.id = UUID.randomUUID();
        this.text = text;
    }

    public Answer(final UUID id,
                  final String text) {
        this.id = UUID.randomUUID();
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(text, answer.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
