package pro.sky.applicationquestionanswer.generator;

import pro.sky.applicationquestionanswer.entity.Question;

public class QuestionGenerator {

    static java.util.Random random = new java.util.Random();
    public static final String QUESTION = "Тук тук";
    public static final String ANSWER = "Кто там?";

    public static final String[] RANDOM_QUESTION = {"Тук тук", "Разрешите войти"};
    public static final String[] RANDOM_ANSWER = {"Кто там?", "Войдите"};
    public static final int RAND_QUESTION = random.nextInt(RANDOM_QUESTION.length);
    public static final int RAND_ANSWER = random.nextInt(RANDOM_ANSWER.length);

    public static Question getQuestion() {
        return new Question(QUESTION, ANSWER);
    }

    public static Question getRandomQuestion() {
        return new Question(RANDOM_QUESTION[RAND_QUESTION], RANDOM_ANSWER[RAND_ANSWER]);
    }
}
