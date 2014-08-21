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


    public boolean checkIfCorrectAnswer(Long questionId, String answer) {
        Question question = questionsDao.getQuestionById(questionId);
        if(question.getAnswers().size() > 0 && question.getAnswers().iterator().next().getText().equals(answer)){
            return true;
        }
        return false;
    }

    public Question createNewQuestion(String questionText, String answerText){
        Question question = questionsDao.createQuestion(questionText, answerText);
        return question;
    }

    public void setQuestionsDao(QuestionsDao questionsDao) {
        this.questionsDao = questionsDao;
    }

}
