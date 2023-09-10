package pro.sky.applicationquestionanswer.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pro.sky.applicationquestionanswer.exception.ExceedingRequestsException;

import java.util.Collections;


import static org.junit.jupiter.api.Assertions.*;
import static pro.sky.applicationquestionanswer.generator.QuestionGenerator.*;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @Test
    void getQuestions_withExceedingRequestsException() {

        Mockito.when(javaQuestionService.getAll()).
                thenReturn(Collections.singletonList(getQuestion()));

//        Ожидаемый результат.
        String expectedMessage = "Превышение запросов";

//        Тест.
        Exception exception = assertThrows(ExceedingRequestsException.class, () -> examinerService.getQuestions(4));
        assertEquals(expectedMessage, exception.getMessage());
    }
}