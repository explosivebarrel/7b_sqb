package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

public class QuestionWithOptionsResponse {
    private final UUID id;
    private final String text;
    private final List<Answer> answerList;

    @JsonCreator
    public QuestionWithOptionsResponse(@JsonProperty("id") final UUID id,
                                       @JsonProperty("text") final String text,
                                       @JsonProperty("answers") final List<Answer> answerList) {
        this.id = id;
        this.text = text;
        this.answerList = answerList;
    }

    public UUID getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    @JsonProperty("answers")
    public List<Answer> getAnswerList() {
        return answerList;
    }
}
