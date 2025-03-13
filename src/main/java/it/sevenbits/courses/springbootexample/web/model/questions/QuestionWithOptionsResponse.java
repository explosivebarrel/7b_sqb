package it.sevenbits.courses.springbootexample.web.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.courses.springbootexample.core.model.answers.Answer;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class QuestionWithOptionsResponse {
    private final UUID id;
    private final String text;
    private final List<Answer> answerList;

    /**
     *
     * @param id id
     * @param text text
     * @param answerList al
     */
    @JsonCreator
    public QuestionWithOptionsResponse(@JsonProperty("questionId") final UUID id,
                                       @JsonProperty("questionText") final String text,
                                       @JsonProperty("answersList") final List<Answer> answerList) {
        this.id = id;
        this.text = text;
        this.answerList = answerList;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("questionId")
    public UUID getId() {
        return id;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("questionText")
    public String getText() {
        return text;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("answersList")
    public List<Answer> getAnswerList() {
        return answerList;
    }
}
