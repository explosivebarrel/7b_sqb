package it.sevenbits.courses.springbootexample.core.repository.rooms;

import it.sevenbits.courses.springbootexample.core.model.rooms.Room;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class JdbcRoomsRepository implements IRoomsRepository {
    private final JdbcOperations jdbcOperations;

    public JdbcRoomsRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    private void updateCurrentGame(String roomId, UUID gameId) {
        String sql = "UPDATE rooms SET currentGameId = ? WHERE id = ?";
        jdbcOperations.update(sql,
                gameId != null ? gameId.toString() : null,
                roomId
        );
    }

    @Override
    public List<Room> getAll() {
        String sql = "SELECT id, ownerId, name, password, isPublic, currentGameId FROM rooms";
        return jdbcOperations.query(sql,
                (rs, rowNum) -> {
                    Room r = new Room(
                            rs.getString("id"),
                            UUID.fromString(rs.getString("ownerId")),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getBoolean("isPublic")
                    );

                    r.setCurrentGameId(UUID.fromString(rs.getString("currentGameId")));

                    return r;
                }
        );
    }

    @Override
    public Room findById(String id) {
        String sql = "SELECT ownerId, name, password, isPublic, currentGameId FROM rooms WHERE id = ?";
        return jdbcOperations.queryForObject(sql,
                (rs, rowNum) -> {
                    Room r = new Room(
                            id,
                            UUID.fromString(rs.getString("ownerId")),
                            rs.getString("name"),
                            rs.getString("password"),
                            rs.getBoolean("isPublic")
                    );

                    r.setCurrentGameId(UUID.fromString(rs.getString("currentGameId")));

                    return r;
                },
                id
        );
    }

    @Override
    public Room save(Room room) {
        String sqlInsert = "INSERT INTO rooms (id, ownerId, name, password, isPublic) VALUES (?, ?, ?, ?, ?)";

        try {
            if (findById(room.getId()) != null)
            {
                updateCurrentGame(room.getId(), room.getCurrentGameId());
            }
        } catch (EmptyResultDataAccessException ex) {
            jdbcOperations.update(sqlInsert,
                    room.getId(),
                    room.getOwnerID().toString(),
                    room.getName(),
                    room.getPassword(),
                    room.getPublic()
            );
        }

        return room;
    }
}
