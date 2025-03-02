package it.sevenbits.courses.springbootexample.core.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class QuestionAnswerResponse {
    private UUID correctAnswerId;
    private UUID nextQuestionId;
    private long totalScore;
    private long questionScore;

    @JsonCreator
    public QuestionAnswerResponse(@JsonProperty("correctAnswerId") final UUID correctAnswerId,
                                  @JsonProperty("nextQuestionId") final UUID nextQuestionId,
                                  @JsonProperty("totalScore") final long totalScore,
                                  @JsonProperty("questionScore") final long questionScore) {
        this.correctAnswerId = correctAnswerId;
        this.nextQuestionId = nextQuestionId;
        this.totalScore = totalScore;
        this.questionScore = questionScore;
    }
}
