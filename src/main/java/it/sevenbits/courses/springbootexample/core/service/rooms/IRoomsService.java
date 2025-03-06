package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;

import java.util.List;
/**
 *
 */
public interface IRoomsService {
    /**
     *
     * @return return
     */
    List<Room> getAll();
    // Room findById(UUID id);

    /**
     *
     * @param id id
     * @return return
     */
    Room findById(String id);

    /**
     *
     * @param answer answer
     * @return return
     */
    Room save(Room answer);
}
