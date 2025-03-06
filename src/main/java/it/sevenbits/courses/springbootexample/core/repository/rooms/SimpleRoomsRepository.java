package it.sevenbits.courses.springbootexample.core.repository.rooms;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.*;


public class SimpleRoomsRepository implements IRoomsRepository {
    private final Map<String, Room> roomMap = new HashMap<>();

    @Override
    public List<Room> getAll() {
        return new ArrayList<>(roomMap.values());
    }

    @Override
    public Room findById(String id) {
        return roomMap.get(id);
    }

    @Override
    public Room save(Room room) {
        return roomMap.put(room.getId(), room);
    }
}
