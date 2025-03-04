package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class QuestionIdResponse {
    private final UUID id;

    @JsonCreator
    public QuestionIdResponse(@JsonProperty("id") final UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
