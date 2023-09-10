package pro.sky.applicationquestionanswer.service;

import org.springframework.stereotype.Service;
import pro.sky.applicationquestionanswer.entity.Question;
import pro.sky.applicationquestionanswer.exception.ExceedingRequestsException;

import java.util.*;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    Random random;

    QuestionService questionService;

    ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {

        Set<Question> randomQuestion = new HashSet<>();

        if (amount < 0 || amount > questionService.getAll().size()) {
            throw new ExceedingRequestsException("Превышение запросов");
        }

        while (randomQuestion.size() < amount) {
            randomQuestion.add(questionService.getRandomQuestion());
        }

        return randomQuestion;
    }
}
