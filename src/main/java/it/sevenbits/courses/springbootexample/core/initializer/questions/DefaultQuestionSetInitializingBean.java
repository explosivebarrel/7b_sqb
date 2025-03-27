package it.sevenbits.courses.springbootexample.core.initializer.questions;

import it.sevenbits.courses.springbootexample.core.model.answers.Answer;
import it.sevenbits.courses.springbootexample.core.model.questions.Question;
import it.sevenbits.courses.springbootexample.core.model.questionsets.ManualQuestionSet;
import it.sevenbits.courses.springbootexample.core.model.questionsets.QuestionSet;
import it.sevenbits.courses.springbootexample.core.service.answers.IAnswersService;
import it.sevenbits.courses.springbootexample.core.service.questions.IQuestionsService;
import it.sevenbits.courses.springbootexample.core.service.questionsets.IQuestionSetsService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

/**
 *
 */
@Component
public class DefaultQuestionSetInitializingBean implements InitializingBean {
    @Autowired
    private IAnswersService answersService;
    @Autowired
    private IQuestionSetsService questionSetsService;
    @Autowired
    private IQuestionsService questionsService;

    /**
     *
     * @throws Exception ex
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        UUID qsnid = UUID.fromString("00000000-0000-0000-0000-000000000000");

        try {
            if (questionSetsService.findById(qsnid) != null) {
                return;
            }
        } catch (EmptyResultDataAccessException ex) {
            System.out.println("Initialization");
        }

        QuestionSet questionSet;

        Question question1;
        List<Answer> answers1 = new LinkedList<>();
        answers1.add(new Answer("Answer 1"));
        answers1.add(new Answer("Answer 2"));
        answers1.add(new Answer("Answer 3"));
        answers1.add(new Answer("Answer 4"));
        question1 = new Question(
            new ArrayList<UUID>(answers1.subList(1, answers1.size()).stream().map(Answer::getId).toList()),
            answers1.get(0).getId(),
            "Lorem ipsum dolor sit amet, " +
                    "consectetuer adipiscing elit, " +
                    "sed diam nonummy nibh euismod tincidunt " +
                    "ut laoreet dolore magna aliquam erat " +
                    "volutpat. Ut wisi enim ad minim veniam, " +
                    "quis nostrud exerci tation ullamcorper " +
                    "suscipit lobortis nisl ut aliquip ex ea " +
                    "commodo consequat?");
        for (var a: answers1) {
            answersService.save(a);
        }
        questionsService.save(question1);

        Question question2;
        List<Answer> answers2 = new LinkedList<>();
        answers2.add(new Answer("Answer 1"));
        answers2.add(new Answer("Answer 2"));
        answers2.add(new Answer("Answer 3"));
        answers2.add(new Answer("Answer 4"));
        answers2.add(new Answer("Answer 5"));
        question2 = new Question(
                new ArrayList<UUID>(answers2.subList(1, answers2.size()).stream().map(Answer::getId).toList()),
                answers2.get(0).getId(),
                "Lorem ipsum dolor sit amet, " +
                        "consectetuer adipiscing elit, " +
                        "sed diam nonummy nibh euismod tincidunt " +
                        "ut laoreet dolore magna aliquam erat " +
                        "volutpat. Ut wisi enim ad minim veniam, " +
                        "quis nostrud exerci tation ullamcorper " +
                        "suscipit lobortis nisl ut aliquip ex ea " +
                        "commodo consequat?");
        for (var a: answers2) {
            answersService.save(a);
        }
        questionsService.save(question2);

        questionSet = new ManualQuestionSet(
            qsnid,
            "Manual set 1",
            "Created on whole system initialization",
            new ArrayList<>(
                List.of(
                    question1.getId(),
                    question2.getId()
                )
            )
        );

        questionSetsService.save(questionSet);
    }
}
