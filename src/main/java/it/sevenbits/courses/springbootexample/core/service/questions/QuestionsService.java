package it.sevenbits.courses.springbootexample.core.service.questions;

import it.sevenbits.courses.springbootexample.core.model.categories.Category;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.repository.questions.IQuestionsRepository;

import java.util.List;
import java.util.UUID;

public class QuestionsService implements IQuestionsService {
    private final IQuestionsRepository questionsRepository;

    public QuestionsService(IQuestionsRepository questionsRepository) {
        this.questionsRepository = questionsRepository;
    }

    @Override
    public List<Question> getAll() {
        return questionsRepository.getAll();
    }

    @Override
    public List<Question> findByCategory(Category category) {
        return questionsRepository.findByCategory(category);
    }

    @Override
    public List<Question> findByText(String content) {
        return questionsRepository.findByText(content);
    }

    @Override
    public Question findById(UUID id) {
        return questionsRepository.findById(id);
    }

    @Override
    public Question save(Question question) {
        return questionsRepository.save(question);
    }
}
