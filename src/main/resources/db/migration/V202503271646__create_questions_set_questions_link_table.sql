CREATE TABLE questionSetQuestions (
    questionSetId VARCHAR(36) REFERENCES questionSets(id) ON DELETE CASCADE,
    questionId VARCHAR(36),
    sortOrder INT NOT NULL DEFAULT 0, -- Порядок вопроса в наборе
    PRIMARY KEY (questionSetId, questionId)
);

-- Индексы для быстрого поиска
CREATE INDEX idxQuestionSet ON questionSetQuestions (questionSetId);
CREATE INDEX idxQuestion ON questionSetQuestions (questionId);