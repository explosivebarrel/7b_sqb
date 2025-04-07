package it.sevenbits.courses.springbootexample.core.model.games;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.courses.springbootexample.core.model.players.PlayerScore;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.*;

/**
 *
 */
public class Game {
    private UUID id;
    private QuestionSet questions;
    private int questionIndex;
    private GameStatus status;
    private List<PlayerScore> playersScore;
    private Date createdAt;

    /**
     *
     * @param id id
     * @param questions questions
     */
    @JsonCreator
    public Game(@JsonProperty("id") final UUID id,
                @JsonProperty("questions") final QuestionSet questions,
                @JsonProperty("questionNumber") final int questionNumber,
                @JsonProperty("status") final GameStatus status,
                @JsonProperty("playersScore") final List<PlayerScore> playersScore,
                @JsonProperty("createdAt") final Date createdAt) {
        this.id = id;
        this.questions = questions;
        this.questionIndex = questionNumber;
        this.status = status;
        this.playersScore = playersScore;
        this.createdAt = createdAt;
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
    public QuestionSet getQuestions() {
        return questions;
    }

    /**
     *
     * @return rt
     */
    public int getQuestionIndex() {
        return questionIndex;
    }

    /**
     *
     * @return rt
     */
    public GameStatus getStatus() {
        return status;
    }

    /**
     *
     * @return rt
     */
    public List<PlayerScore> getPlayersScore() {
        return playersScore;
    }

    /**
     *
     * @return rt
     */
    public Date getCreatedAt() {
        return createdAt;
    }
}
