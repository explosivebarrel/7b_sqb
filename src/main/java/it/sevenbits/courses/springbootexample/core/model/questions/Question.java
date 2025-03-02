package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Question {
    private UUID id;
    private List<UUID> incorrectAnswerIDs;
    private UUID correctAnswerID;
    private String text;

    @JsonCreator
    public Question(@JsonProperty("incorrectAnswerIDs") final List<UUID> incorrectAnswerIDs,
                    @JsonProperty("correctAnswerID") final UUID correctAnswerId,
                    @JsonProperty("text") final String text) {
        this.id = UUID.randomUUID();
        this.incorrectAnswerIDs = incorrectAnswerIDs;
        this.correctAnswerID = correctAnswerId;
        this.text = text;
    }

    public Question(final UUID id,
                    final List<UUID> incorrectAnswerIDs,
                    final UUID correctAnswerID,
                    final String text) {
        this.id = id;
        this.incorrectAnswerIDs = incorrectAnswerIDs;
        this.correctAnswerID = correctAnswerID;
        this.text = text;
    }

    public UUID getId() {
        return id;
    }

    public List<UUID> getIncorrectAnswerIDs() {
        return incorrectAnswerIDs;
    }

    public UUID getCorrectAnswerID() {
        return correctAnswerID;
    }

    public List<UUID> getAllAnswerIDs() {
        List<UUID> tmp = getIncorrectAnswerIDs();
        tmp.add(getCorrectAnswerID());
        return tmp;
    }

    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) && Objects.equals(incorrectAnswerIDs, question.incorrectAnswerIDs) && Objects.equals(correctAnswerID, question.correctAnswerID) && Objects.equals(text, question.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incorrectAnswerIDs, correctAnswerID, text);
    }
}
