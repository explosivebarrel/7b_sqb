CREATE TABLE questionSets (
    id VARCHAR(36) PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    createdAt TIMESTAMP DEFAULT NOW()
);