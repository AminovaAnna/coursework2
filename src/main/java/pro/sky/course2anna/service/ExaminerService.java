package pro.sky.course2anna.service;

import pro.sky.course2anna.model.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection <Question> getQuestions(int amount);
}
