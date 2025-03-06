package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 *
 */
public class Question {
    private UUID id;
    private List<UUID> incorrectAnswerIDs;
    private UUID correctAnswerID;
    private String text;

    /**
     *
     * @param incorrectAnswerIDs incorrectAnswerIDs
     * @param correctAnswerId correctAnswerId
     * @param text text
     */
    @JsonCreator
    public Question(@JsonProperty("incorrectAnswerIDs") final List<UUID> incorrectAnswerIDs,
                    @JsonProperty("correctAnswerID") final UUID correctAnswerId,
                    @JsonProperty("text") final String text) {
        this.id = UUID.randomUUID();
        this.incorrectAnswerIDs = incorrectAnswerIDs;
        this.correctAnswerID = correctAnswerId;
        this.text = text;
    }

    /**
     *
     * @param id id
     * @param incorrectAnswerIDs incorrectAnswerIDs
     * @param correctAnswerID correctAnswerId
     * @param text text
     */
    public Question(final UUID id,
                    final List<UUID> incorrectAnswerIDs,
                    final UUID correctAnswerID,
                    final String text) {
        this.id = id;
        this.incorrectAnswerIDs = incorrectAnswerIDs;
        this.correctAnswerID = correctAnswerID;
        this.text = text;
    }

    /**
     *
     * @return rt
     */
    public UUID getId() {
        return id;
    }

    /**
     *
     * @return rt
     */
    @JsonIgnore
    public List<UUID> getIncorrectAnswerIDs() {
        return incorrectAnswerIDs;
    }

    /**
     *
     * @return rt
     */
    @JsonIgnore
    public UUID getCorrectAnswerID() {
        return correctAnswerID;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("answers")
    public List<UUID> getAllAnswerIDs() {
        List<UUID> tmp = new ArrayList<UUID>(getIncorrectAnswerIDs().size());
        tmp.addAll(getIncorrectAnswerIDs());
        tmp.add(getCorrectAnswerID());
        return tmp;
    }

    /**
     *
     * @return rt
     */
    public String getText() {
        return text;
    }

    /**
     *
     * @param o o
     * @return rt
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
            Objects.equals(incorrectAnswerIDs, question.incorrectAnswerIDs) &&
            Objects.equals(correctAnswerID, question.correctAnswerID) &&
            Objects.equals(text, question.text);
    }

    /**
     *
     * @return rt
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, incorrectAnswerIDs, correctAnswerID, text);
    }
}
