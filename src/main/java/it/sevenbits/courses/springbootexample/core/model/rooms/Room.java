package it.sevenbits.courses.springbootexample.core.model.rooms;

import java.util.List;
import java.util.UUID;

public class Room {
    private UUID ownerID;
    private List<UUID> participantsIDs;
    private String name;
    private String password;
    private Boolean isPublic = false;
}
