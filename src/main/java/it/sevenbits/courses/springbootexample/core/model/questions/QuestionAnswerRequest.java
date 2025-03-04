package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class QuestionAnswerRequest {
    private UUID answerId;

    @JsonCreator
    public QuestionAnswerRequest(@JsonProperty("answerId") final UUID answerId) {
        this.answerId = answerId;
    }

    public UUID getAnswerId() {
        return answerId;
    }
}
