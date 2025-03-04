package it.sevenbits.courses.springbootexample.core.initializer.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import it.sevenbits.courses.springbootexample.core.service.rooms.IRoomsService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DefaultRoomInitializingBean implements InitializingBean {
    @Autowired
    IRoomsService roomsService;

    @Override
    public void afterPropertiesSet() throws Exception {
        roomsService.save(new Room(UUID.fromString("00000000-0000-0000-0000-000000000000"), UUID.fromString("00000000-0000-0000-0000-000000000000"), "Default room", "", true));
    }
}
