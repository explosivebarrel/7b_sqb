-- Создание таблицы games
CREATE TABLE rooms (
    id VARCHAR(36) PRIMARY KEY,
    ownerId VARCHAR(36) NOT NULL,
    name VARCHAR(255) NOT NULL,
    password VARCHAR(512),
    isPublic BOOLEAN NOT NULL,
    currentGameId VARCHAR(36),
    createdAt TIMESTAMP DEFAULT NOW()
);

-- Комментарий к таблице (опционально)
COMMENT ON TABLE rooms IS 'Таблица для хранения комнат';