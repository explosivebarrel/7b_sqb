package it.sevenbits.courses.springbootexample.core.model.games;

import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;

import java.util.Iterator;
import java.util.UUID;

public abstract class Game {
    private UUID id;
    private QuestionSet questions;
    private Iterator<Question> questionIterator;
}
