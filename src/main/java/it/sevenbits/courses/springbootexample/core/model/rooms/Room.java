package it.sevenbits.courses.springbootexample.core.model.rooms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

public class Room {
    private UUID id;
    private UUID ownerID;
    private List<UUID> participantsIDs;
    private String name;
    private String password;
    private Boolean isPublic = false;
    private UUID currentGameId;

    @JsonCreator
    public Room(@JsonProperty("id") final UUID id,
                @JsonProperty("ownerid") final UUID ownerID,
                @JsonProperty("name") final String name,
                @JsonProperty("password") final String password,
                @JsonProperty("ispublic") final Boolean isPublic) {
        this.id = id;
        this.ownerID = ownerID;
        this.name = name;
        this.password = password;
        this.isPublic = isPublic;
    }

    public UUID getId() {
        return id;
    }

    public UUID getOwnerID() {
        return ownerID;
    }

    public List<UUID> getParticipantsIDs() {
        return participantsIDs;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public UUID getCurrentGameId() {
        return currentGameId;
    }

    public void setCurrentGameId(UUID currentGameId) {
        this.currentGameId = currentGameId;
    }
}
