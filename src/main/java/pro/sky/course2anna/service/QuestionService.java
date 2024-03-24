package pro.sky.course2anna.service;

import pro.sky.course2anna.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question add (String question, String answer);

    Question add (Question question);

    Question remove (Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();
}
