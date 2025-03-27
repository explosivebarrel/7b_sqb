package it.sevenbits.courses.springbootexample.core.model.games;

/**
 *
 */
public enum GameStatus {
    /**
     *
     */
    READY_TO_START("READY_TO_START"),
    /**
     *
     */
    IN_PROGRESS("IN_PROGRESS"),
    /**
     *
     */
    FINISHED("FINISHED");
    private final String name;

    /**
     * Constructor
     * @param name name
     */
    GameStatus(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
