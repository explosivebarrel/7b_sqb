package it.sevenbits.courses.springbootexample.core.service.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.repository.rooms.IRoomsRepository;

import java.util.List;
import java.util.UUID;

public class RoomsService implements IRoomsService {
    private final IRoomsRepository roomsRepository;

    public RoomsService(IRoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    @Override
    public List<Room> getAll() {
        return roomsRepository.getAll();
    }

    @Override
    public Room findById(UUID id) {
        return roomsRepository.findById(id);
    }

    @Override
    public Room save(Room answer) {
        return roomsRepository.save(answer);
    }
}
