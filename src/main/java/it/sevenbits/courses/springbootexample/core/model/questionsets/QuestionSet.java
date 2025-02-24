package it.sevenbits.courses.springbootexample.core.model.questionsets;

import java.util.List;
import java.util.UUID;

public abstract class QuestionSet {
    private UUID id;
    private String label;
    private String description;
    public abstract List<UUID> getQuestionIDs();
}
