package it.sevenbits.courses.springbootexample.core.repository.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 *
 */
public class SimpleRoomsRepository implements IRoomsRepository {
    private final Map<String, Room> roomMap = new HashMap<>();

    /**
     *
     * @return rt
     */
    @Override
    public List<Room> getAll() {
        return new ArrayList<>(roomMap.values());
    }

    /**
     *
     * @param id id
     * @return rt
     */
    @Override
    public Room findById(final String id) {
        return roomMap.get(id);
    }

    /**
     *
     * @param room rm
     * @return rt
     */
    @Override
    public Room save(final Room room) {
        return roomMap.put(room.getId(), room);
    }
}
