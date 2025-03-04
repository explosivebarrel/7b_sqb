package it.sevenbits.courses.springbootexample.core.model.questionsets;

import java.util.List;
import java.util.UUID;

public class ManualQuestionSet extends QuestionSet {
    private final List<UUID> questions;

    public ManualQuestionSet(UUID id, String label, String description, List<UUID> questions) {
        super(id, label, description);
        this.questions = questions;
    }

    @Override
    public List<UUID> getQuestionIDs() {
        return questions;
    }
}
