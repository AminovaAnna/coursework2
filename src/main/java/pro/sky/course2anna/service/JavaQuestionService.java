package pro.sky.course2anna.service;

import org.springframework.stereotype.Service;
import pro.sky.course2anna.exceptions.NotFoundQuestionException;
import pro.sky.course2anna.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> storage = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    @Override
    public Question add(Question question) {
        storage.add(question);
        return question;
    }

    @Override
    public Question remove(Question question) {
        if (storage.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(storage);
    }

    @Override
    public Question getRandomQuestion() {
        var index = random.nextInt(storage.size());
        var i = 0;
        for (Question question : storage) {
            if (index == i) {
                return question;
            }
            i++;
        }
        throw new NotFoundQuestionException();
    }
}
