package it.sevenbits.courses.springbootexample.core.model.users;

import java.util.UUID;

/**
 *
 */
public class User {
    private UUID id;
    private String name;
    private String email;
    private Long registerTimestamp;
    private Long lastSeenOnline;
}
