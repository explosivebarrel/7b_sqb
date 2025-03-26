-- Создание таблицы games
CREATE TABLE rooms (
    id VARCHAR(36) PRIMARY KEY,
    ownerId VARCHAR(36) NOT NULL,
    name VARCHAR(512) NOT NULL,
    password VARCHAR(512),
    isPublic BIT NOT NULL,
    currentGameId VARCHAR(36)
);

-- Комментарий к таблице (опционально)
COMMENT ON TABLE rooms IS 'Таблица для хранения комнат';