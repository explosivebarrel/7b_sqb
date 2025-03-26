-- Создание таблицы games
CREATE TABLE games (
    id UUID PRIMARY KEY,
    questionSetId UUID NOT NULL
);

-- Комментарий к таблице (опционально)
COMMENT ON TABLE games IS 'Таблица для хранения игр';
