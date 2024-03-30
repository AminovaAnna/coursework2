package pro.sky.course2anna.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.course2anna.exceptions.NotEnoughQuestionException;
import pro.sky.course2anna.model.Question;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    static List<Question> JAVA_QUESTIONS = List.of(
            new Question("book", "read"),
            new Question("song", "sing"),
            new Question("program", "write"));

    @Mock
    JavaQuestionService JavaQuestionService;
    ExaminerServiceImpl ExaminerService;

    @BeforeEach
    void setUp() {
        ExaminerService = new ExaminerServiceImpl(JavaQuestionService);
        when(JavaQuestionService.getAll()).thenReturn(JAVA_QUESTIONS);
    }

    @Test
    void testNotEnoughQuestion() {
        assertThrows(NotEnoughQuestionException.class, () -> ExaminerService.getQuestions(100000));
    }

    @Test
    void testRandomQuestion() {
        when(JavaQuestionService.getRandomQuestion())
                .thenReturn(JAVA_QUESTIONS.get(0))
                .thenReturn(JAVA_QUESTIONS.get(1));


        var actual = ExaminerService.getQuestions(2);

        assertThat(actual).containsExactlyInAnyOrder(
                JAVA_QUESTIONS.get(0),
                JAVA_QUESTIONS.get(1));


    }
}