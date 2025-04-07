package it.sevenbits.courses.springbootexample.core.model.players;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class PlayerScore {
    private UUID scoreRecordId;
    private UUID playerId;
    private int score;

    @JsonCreator
    public PlayerScore(@JsonProperty("scoreRecordId") final UUID scoreRecordId,
                       @JsonProperty("playerId") final UUID playerId,
                       @JsonProperty("score") final int score) {
        this.scoreRecordId = scoreRecordId;
        this.playerId = playerId;
        this.score = score;
    }

    public UUID getPlayerId() {
        return playerId;
    }

    public long getScore() {
        return score;
    }
}
