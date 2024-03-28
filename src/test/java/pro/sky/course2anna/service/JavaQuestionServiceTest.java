package pro.sky.course2anna.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import pro.sky.course2anna.exceptions.NotFoundQuestionException;
import pro.sky.course2anna.model.Question;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {


    JavaQuestionService JavaQuestionService = new JavaQuestionService();

    @Test
    void testAdd(){
JavaQuestionService.add("Как тебя зовут?","Анна");
JavaQuestionService.add("Как твои дела?","Хорошо");
JavaQuestionService.add("Сколько раз в неделю поливать цветы?","Три");
        assertEquals(3, JavaQuestionService.getAll().size());
        assertThat(JavaQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("Как тебя зовут?","Анна"),
                new Question("Как твои дела?","Хорошо"),
                new Question("Сколько раз в неделю поливать цветы?","Три")
        );
    }


    @Test
    void testRemove() {
        JavaQuestionService.add("Как тебя зовут?", "Анна");
        JavaQuestionService.add("Как твои дела?", "Хорошо");
        var removed = JavaQuestionService.remove(new Question("Как тебя зовут?", "Анна"));
        assertThat(removed).isEqualTo(new Question("Как тебя зовут?", "Анна"));
        var empty = JavaQuestionService.remove(new Question("Go", "Do"));
        assertThat(empty).isNull();
        assertThat(JavaQuestionService.getAll()).containsExactlyInAnyOrder(
                new Question("Как твои дела?", "Хорошо")
        );
    }
static List<Question> QUESTIONS =List.of(
        new Question("Как тебя зовут?", "Анна"),
        new Question("Как твои дела?", "Хорошо"),
        new Question("Сколько раз в неделю поливать цветы?", "Три"));
        @Test
        public void testGetRandomQuestion() {

            when(JavaQuestionService.getAll()).thenReturn(List.of(
                    new Question("Как тебя зовут?", "Анна"),
                    new Question("Как твои дела?", "Хорошо"),
                    new Question("Сколько раз в неделю поливать цветы?", "Три")));
            for (int i = 0; i <1000 ; i++) {
                assertTrue(QUESTIONS.contains(JavaQuestionService.getRandomQuestion()));
            }

        }


        @Test
    void testEmptyQuestions(){
        when(JavaQuestionService.getAll()).thenReturn(List.of());
        assertThrows(NotFoundQuestionException.class, () -> JavaQuestionService.getRandomQuestion());




    }

////не поняла как писать тесты
//    @BeforeEach
//    void setUp() {
//        when(Collections.unmodifiableSet(storage).thenReturn(List.of(  // особенно это
//            new Question ("test1", "1test"),
//            new Question ("test2", "2test"),
//            new Question ("test3", "3test")));
//    }
//
//    @Test
//    void testRandomQuestion() {
//        Question question = new Question("Test question", "Test answer");
//        when(storage.size()).thenReturn(1);
//        when(storage.iterator()).thenReturn(Collections.singletonList(question).iterator());
//
//        assertEquals(question, questionService.getRandomQuestion());
//    }
//
//    @Test
//    void testGetRandomQuestionWhenStorageIsEmpty() {
//        when(storage.size()).thenReturn(0);
//
//        assertThrows(NotFoundQuestionException.class, () -> questionService.getRandomQuestion());
//    }
}