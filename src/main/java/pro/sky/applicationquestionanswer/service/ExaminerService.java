package pro.sky.applicationquestionanswer.service;

import pro.sky.applicationquestionanswer.entity.Question;

import java.util.Collection;

public interface ExaminerService {

    Collection<Question>  getQuestions(int amount);
}
