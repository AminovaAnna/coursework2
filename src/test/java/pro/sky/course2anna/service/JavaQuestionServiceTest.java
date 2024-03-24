package pro.sky.course2anna.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import pro.sky.course2anna.exceptions.NotFoundQuestionException;
import pro.sky.course2anna.model.Question;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {

    @Mock
    private Set<Question> storage;

    @InjectMocks
    private JavaQuestionService questionService;
//не поняла как писать тесты
    @BeforeEach
    void setUp() {
        when(Collections.unmodifiableSet(storage).thenReturn(List.of(  // особенно это
            new Question ("test1", "1test"),
            new Question ("test2", "2test"),
            new Question ("test3", "3test")));
    }

    @Test
    void testRandomQuestion() {
        Question question = new Question("Test question", "Test answer");
        when(storage.size()).thenReturn(1);
        when(storage.iterator()).thenReturn(Collections.singletonList(question).iterator());

        assertEquals(question, questionService.getRandomQuestion());
    }

    @Test
    void testGetRandomQuestionWhenStorageIsEmpty() {
        when(storage.size()).thenReturn(0);

        assertThrows(NotFoundQuestionException.class, () -> questionService.getRandomQuestion());
    }
}