CREATE TABLE questionAnswers (
    questionId VARCHAR(36) REFERENCES questions(id) ON DELETE CASCADE,
    answerId VARCHAR(36) REFERENCES answers(id) ON DELETE CASCADE,
    isCorrect BOOLEAN DEFAULT FALSE, -- Правильность ответа в контексте вопроса
    sortOrder INT NOT NULL DEFAULT 0, -- Порядок отображения ответов
    PRIMARY KEY (questionId, answerId)
);

-- Индексы для ускорения поиска
CREATE INDEX idxQuestionAnswersQuestion ON questionAnswers (questionId);
CREATE INDEX idxQuestionAnswersAnswer ON questionAnswers (answerId);