package it.sevenbits.courses.springbootexample.web.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 *
 */
public class QuestionIdResponse {
    private final UUID id;

    /**
     *
     * @param id id
     */
    @JsonCreator
    public QuestionIdResponse(@JsonProperty("questionId") final UUID id) {
        this.id = id;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("questionId")
    public UUID getId() {
        return id;
    }
}
