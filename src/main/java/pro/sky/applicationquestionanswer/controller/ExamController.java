package pro.sky.applicationquestionanswer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.applicationquestionanswer.entity.Question;
import pro.sky.applicationquestionanswer.service.ExaminerService;

import java.util.Collection;

@RestController
@RequestMapping(path = "/exam")
public class ExamController {

    @ExceptionHandler({RuntimeException.class})
    public String handleException(Exception e) {
        return  e.getMessage();
    }

    private final ExaminerService examinerService;

    ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping()
    public Collection<Question> getQuestions(@RequestParam int amount) {
        return examinerService.getQuestions(amount);
    }
}
