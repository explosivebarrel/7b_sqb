package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 *
 */
public class QuestionAnswerRequest {
    private UUID answerId;

    /**
     *
     * @param answerId aid
     */
    @JsonCreator
    public QuestionAnswerRequest(@JsonProperty("answerId") final String answerId) {
        this.answerId = UUID.fromString(answerId);
    }

    /**
     *
     * @return rt
     */
    public UUID getAnswerId() {
        return answerId;
    }
}
