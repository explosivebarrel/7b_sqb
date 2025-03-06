package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;

import java.util.List;

/**
 *
 */
public class RoomsService implements IRoomsService {
    private final IRoomsRepository roomsRepository;

    /**
     *
     * @param roomsRepository repository
     */
    public RoomsService(final IRoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    /**
     *
     * @return return
     */
    @Override
    public List<Room> getAll() {
        return roomsRepository.getAll();
    }

    /**
     *
     * @param id id
     * @return return
     */
    @Override
    public Room findById(final String id) {
        return roomsRepository.findById(id);
    }

    /**
     *
     * @param answer answer
     * @return return
     */
    @Override
    public Room save(final Room answer) {
        return roomsRepository.save(answer);
    }
}
