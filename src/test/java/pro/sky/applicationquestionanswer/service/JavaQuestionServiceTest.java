package pro.sky.applicationquestionanswer.service;

import org.junit.jupiter.api.Test;
import pro.sky.applicationquestionanswer.entity.Question;
import pro.sky.applicationquestionanswer.exception.QuestionAddedException;
import pro.sky.applicationquestionanswer.exception.QuestionNotFoundException;
import pro.sky.applicationquestionanswer.generator.QuestionGenerator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.applicationquestionanswer.generator.QuestionGenerator.*;

class JavaQuestionServiceTest {

    private final JavaQuestionService javaQuestionService = new JavaQuestionService();
    @Test
    void add_success() {

//        Входные данные.
        String question = QUESTION;
        String answer = ANSWER;

//        Ожидаемый результат.
        Question expected = getQuestion();

//        Тест.
        Question actual = javaQuestionService.add(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void add_withQuestionAddedException() {

//        Входные данные.
        String question = QUESTION;
        String answer = ANSWER;

//        Ожидаемый результат.
        javaQuestionService.add(QUESTION, ANSWER);
        String expectedMessage = "Вопрос уже добавлен";

//        Тест.
        Exception exception = assertThrows(QuestionAddedException.class, () -> javaQuestionService
                .add(QUESTION, ANSWER));
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testAdd_success() {

//        Входные данные.
        String question = QUESTION;
        String answer = ANSWER;

//        Ожидаемый результат.
        Question expected = getQuestion();

//        Тест.
        Question actual = javaQuestionService.add(question, answer);
        assertEquals(expected, actual);
    }

    @Test
    void remove_withQuestionNotFoundException() {

//        Тест.
        assertThrows(QuestionNotFoundException.class, () -> javaQuestionService.
                remove(getQuestion()));
    }

    @Test
    void getAll_success() {

//        Входные данные.
        String question = QUESTION;
        String answer = ANSWER;

//        Ожидаемый результат.
        Set<Question> expected = new HashSet<>(List.of(getQuestion()));

//        Тест.
        Set<Question> actual = new HashSet<>(List.of(new Question(question, answer)));
        assertEquals(expected, actual);
    }

    @Test
    void getRandomQuestion_success() {

//        Входные данные.
        String[] randomQuestion = RANDOM_QUESTION;
        String[] randomAnswer = RANDOM_ANSWER;
        int randQuestion = RAND_QUESTION;
        int randAnswer = RAND_ANSWER;

//        Ожидаемый результат.
        Question expected = getRandomQuestion();

//        Тест.
        Question actual = new Question(randomQuestion[randQuestion], randomAnswer[randAnswer]);
        assertEquals(expected, actual);
    }
}