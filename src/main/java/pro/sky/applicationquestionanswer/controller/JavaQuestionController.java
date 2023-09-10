package pro.sky.applicationquestionanswer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pro.sky.applicationquestionanswer.entity.Question;
import pro.sky.applicationquestionanswer.service.JavaQuestionService;
import pro.sky.applicationquestionanswer.service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {
    @ExceptionHandler({RuntimeException.class})
    public String handleException(Exception e) {
        return  e.getMessage();
    }

    private final QuestionService questionService;

    JavaQuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping(path = "/add")
    public Question addQuestion(@RequestParam ("question")String question,
                                @RequestParam ("answer")String answer) {
        return questionService.add(question, answer);
    }

    @GetMapping(path = "/remove")
    public Question removeQuestion(@RequestParam String question, String answer) {

        Question removedQuestion = new Question(question, answer);
        return questionService.remove(removedQuestion);
    }

    @GetMapping()
    public Collection<Question> getQuestions() {
        return questionService.getAll();
    }
}
