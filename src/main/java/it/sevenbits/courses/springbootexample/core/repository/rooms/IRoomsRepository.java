package it.sevenbits.courses.springbootexample.core.repository.rooms;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.List;
import java.util.UUID;

public interface IRoomsRepository {
    List<Room> getAll();
    Room findById(UUID id);
    Room save(Room answer);
}
