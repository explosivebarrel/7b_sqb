package it.sevenbits.courses.springbootexample.core.model.questionsets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public abstract class QuestionSet {
    private UUID id;
    private String label;
    private String description;

    @JsonCreator
    public QuestionSet(@JsonProperty("id") final UUID id,
                       @JsonProperty("label") final String label,
                       @JsonProperty("description") final String description) {
        this.id = id;
        this.label = label;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getDescription() {
        return description;
    }

    public abstract List<UUID> getQuestionIDs();
}
