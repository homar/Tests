package pl.homar.services;

import pl.homar.dao.QuestionsDao;
import pl.homar.entity.Question;

import java.util.List;
import java.util.Random;

/**
 * Created by Konrad on 8/20/2014.
 */
public class QuestionsService {

    private QuestionsDao questionsDao;

    public Question getRandomQuestion(){
        List<Question> questions = questionsDao.getAllQuestions();
        Random randomGenerator = new Random();
        int nextIndex = randomGenerator.nextInt(questions.size());
        return questions.get(nextIndex);
    }

    public void setQuestionsDao(QuestionsDao questionsDao) {
        this.questionsDao = questionsDao;
    }

    public boolean checkIfCorrectAnswer(Long questionId, String answer) {
        System.out.println(questionId);
        Question question = questionsDao.getQuestionById(questionId);
        if(question.getAnswers().get(0).getText().equals(answer)){
            return true;
        }
        return false;
    }
}
