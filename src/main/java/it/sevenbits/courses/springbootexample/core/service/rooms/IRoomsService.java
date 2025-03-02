package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.List;
import java.util.UUID;

public interface IRoomsService {
    List<Room> getAll();
    Room findById(UUID id);
    Room save(Room answer);
}
