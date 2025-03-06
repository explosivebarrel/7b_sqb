package it.sevenbits.courses.springbootexample.core.model.rooms;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

/**
 *
 */
public class Room {
    // private UUID id; // Should be UUID
    private String id;
    private UUID ownerID;
    private List<UUID> participantsIDs;
    private String name;
    private String password;
    private Boolean isPublic = false;
    private UUID currentGameId;

    /**
     *
     * @param id id
     * @param ownerID ownerID
     * @param name name
     * @param password password
     * @param isPublic isPublic
     */
    @JsonCreator
    public Room(@JsonProperty("id") final String id,
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

    /**
     *
     * @return rt
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @return rt
     */
    public UUID getOwnerID() {
        return ownerID;
    }

    /**
     *
     * @return rt
     */
    public List<UUID> getParticipantsIDs() {
        return participantsIDs;
    }

    /**
     *
     * @return rt
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return rt
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return rt
     */
    public Boolean getPublic() {
        return isPublic;
    }

    /**
     *
     * @return rt
     */
    public UUID getCurrentGameId() {
        return currentGameId;
    }

    /**
     *
     * @param currentGameId cgid
     */
    public void setCurrentGameId(final UUID currentGameId) {
        this.currentGameId = currentGameId;
    }
}
