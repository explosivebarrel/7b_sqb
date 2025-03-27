-- Создание таблицы games
CREATE TABLE games (
    id VARCHAR(36) PRIMARY KEY,
    questionSetId VARCHAR(36) NOT NULL,
    status VARCHAR(255) NOT NULL,
    createdAt TIMESTAMP DEFAULT NOW()
);

-- Комментарий к таблице (опционально)
COMMENT ON TABLE games IS 'Таблица для хранения игр';
