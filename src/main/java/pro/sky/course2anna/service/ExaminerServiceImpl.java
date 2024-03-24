package pro.sky.course2anna.service;

import org.springframework.stereotype.Service;
import pro.sky.course2anna.exceptions.NotEnoughQuestionException;
import pro.sky.course2anna.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        var allQuestions = questionService.getAll();
        if (amount > allQuestions.size()) {
            throw new NotEnoughQuestionException();
        }
        if (amount == allQuestions.size()) {
            return questionService.getAll();
        }

        Set<Question> questions = new HashSet<>();
        while (questions.size() < amount) {
            var randomQuestion = questionService.getRandomQuestion();
            questions.add(randomQuestion);
        }
        return questions;
    }


}

