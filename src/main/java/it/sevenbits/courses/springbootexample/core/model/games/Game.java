package it.sevenbits.courses.springbootexample.core.model.games;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.Collections;
import java.util.Iterator;
import java.util.UUID;

/**
 *
 */
public class Game {
    private UUID id;
    private QuestionSet questions;
    private Iterator<UUID> questionIterator;

    /**
     *
     * @param id id
     * @param questions questions
     */
    @JsonCreator
    public Game(@JsonProperty("id") final UUID id,
                @JsonProperty("questions") final QuestionSet questions) {
        this.id = id;
        this.questions = questions;
        initQuestionIterator();
    }

    /**
     *
     */
    private void initQuestionIterator() {
        if (questions != null && questions.getQuestionIDs() != null) {
            this.questionIterator = questions.getQuestionIDs().iterator();
        } else {
            this.questionIterator = Collections.emptyIterator();
        }
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
    public Iterator<UUID> getQuestionIterator() {
        if (questionIterator == null) {
            initQuestionIterator();
        }
        return questionIterator;
    }
}
