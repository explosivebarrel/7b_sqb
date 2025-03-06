package it.sevenbits.courses.springbootexample.core.model.questionsets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public abstract class QuestionSet {
    private UUID id;
    private String label;
    private String description;

    /**
     *
     * @param id id
     * @param label l
     * @param description dc
     */
    @JsonCreator
    public QuestionSet(@JsonProperty("id") final UUID id,
                       @JsonProperty("label") final String label,
                       @JsonProperty("description") final String description) {
        this.id = id;
        this.label = label;
        this.description = description;
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
    public String getLabel() {
        return label;
    }

    /**
     *
     * @return rt
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @return rt
     */
    public abstract List<UUID> getQuestionIDs();
}
