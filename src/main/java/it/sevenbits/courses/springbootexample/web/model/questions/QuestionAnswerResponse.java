package it.sevenbits.courses.springbootexample.web.model.questions;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

/**
 *
 */
public class QuestionAnswerResponse {
    private UUID correctAnswerId;
    private UUID nextQuestionId;
    private long totalScore;
    private long questionScore;

    /**
     *
     * @param correctAnswerId caid
     * @param nextQuestionId nqid
     * @param totalScore tts
     * @param questionScore qs
     */
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

    /**
     *
     * @return rt
     */
    @JsonProperty("correctAnswerId")
    public UUID getCorrectAnswerId() {
        return correctAnswerId;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("nextQuestionId")
    public UUID getNextQuestionId() {
        return nextQuestionId;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("totalScore")
    public long getTotalScore() {
        return totalScore;
    }

    /**
     *
     * @return rt
     */
    @JsonProperty("questionScore")
    public long getQuestionScore() {
        return questionScore;
    }
}
