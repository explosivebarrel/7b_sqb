package it.sevenbits.courses.springbootexample.core.model.players;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class Player {
    private UUID userId;
    private UUID playerId;

    @JsonCreator
    public Player(@JsonProperty("userId") final UUID userId,
                  @JsonProperty("userId") final UUID playerId) {
        this.userId = userId;
        this.playerId = playerId;
    }

    public UUID getUserId() {
        return userId;
    }

    public UUID getPlayerId() {
        return playerId;
    }
}
