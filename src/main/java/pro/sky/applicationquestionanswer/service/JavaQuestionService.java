package pro.sky.applicationquestionanswer.service;

import org.springframework.stereotype.Service;
import pro.sky.applicationquestionanswer.entity.Question;
import pro.sky.applicationquestionanswer.exception.QuestionAddedException;
import pro.sky.applicationquestionanswer.exception.QuestionNotFoundException;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService{

    private final Set<Question> questions = new HashSet<>(List.of(
            new Question("Когда выйдет Half-life 3?", "Никогда"),
            new Question("Что лучше Overwatch 2 или Team fortress 2?", "Team fortress 2"),
            new Question("Как называется студия создавшая Half-life?", "Valve"),
            new Question("Смысл жизни, вселенной и вообще?", "42"),
            new Question("Что нужно взять собой для путешествия по галактике?", "Полотенце")
    ));

    @Override
    public Question add(String question, String answer) {

        Question addenQuestion = new Question(question, answer);

        if (questions.contains(addenQuestion)) {
            throw new QuestionAddedException("Вопрос уже добавлен");
        }

        questions.add(addenQuestion);
        return addenQuestion;
    }

    @Override
    public Question add(Question question){

        questions.add(question);
        return question;
    }

    @Override
    public Question remove(Question question){
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException("Вопрос не найден");
        }

        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll(){
        return questions;
    }

    @Override
    public Question getRandomQuestion(){

        java.util.Random random = new java.util.Random();

        return new ArrayList<>(questions).get(random.nextInt(questions.size()));
    }
}
