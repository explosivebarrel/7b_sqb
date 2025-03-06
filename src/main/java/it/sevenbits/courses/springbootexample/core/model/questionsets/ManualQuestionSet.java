package it.sevenbits.courses.springbootexample.core.model.questionsets;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class ManualQuestionSet extends QuestionSet {
    private final List<UUID> questions;

    /**
     *
     * @param id id
     * @param label lb
     * @param description dc
     * @param questions qs
     */
    public ManualQuestionSet(UUID id, String label, String description, List<UUID> questions) {
        super(id, label, description);
        this.questions = questions;
    }

    /**
     *
     * @return rt
     */
    @Override
    public List<UUID> getQuestionIDs() {
        return questions;
    }
}
