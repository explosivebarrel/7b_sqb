package it.sevenbits.courses.springbootexample.core.repository.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.List;

/**
 *
 */
public interface IRoomsRepository {
    /**
     *
     * @return rt
     */
    List<Room> getAll();
    // Room findById(UUID id);

    /**
     *
     * @param id id
     * @return rt
     */
    Room findById(final String id);

    /**
     *
     * @param room r
     * @return rt
     */
    Room save(final Room room);
}
