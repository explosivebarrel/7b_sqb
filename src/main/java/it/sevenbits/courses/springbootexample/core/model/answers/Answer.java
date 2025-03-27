package it.sevenbits.courses.springbootexample.core.model.answers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.UUID;

/**
 *
 */
public class Answer {
    private UUID id;
    private String text;

    /**
     *
     * @param text txt
     */
    public Answer(final String text) {
        this.id = UUID.randomUUID();
        this.text = text;
    }

    /**
     *
     * @param id id
     * @param text text
     */
    @JsonCreator
    public Answer(@JsonProperty("answerId") final UUID id,
                  @JsonProperty("answerText") final String text) {
        this.id = id;
        this.text = text;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("answerId")
    public UUID getId() {
        return id;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("answerText")
    public String getText() {
        return text;
    }

    /**
     *
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
        Answer answer = (Answer) o;
        return Objects.equals(id, answer.id) && Objects.equals(text, answer.text);
    }

    /**
     *
     * @return rt
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, text);
    }
}
