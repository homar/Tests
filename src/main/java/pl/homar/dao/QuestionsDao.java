package pl.homar.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.homar.entity.Answer;
import pl.homar.entity.Question;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Konrad on 8/20/2014.
 */
public class QuestionsDao {

    private SessionFactory sessionFactory;

    public void createQuestion(String questionText, String answerText){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Answer answer = new Answer();
        answer.setText(answerText);
        Question question = new Question();
        question.setText(questionText);
        question.setAnswers(Arrays.asList(answer));
        answer.setQuestion(question);
        session.save(question);
        session.getTransaction().commit();
    }

    public List<Question> getAllQuestions(){
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List<Question> questions = session.createCriteria(Question.class).list();
        session.getTransaction().commit();
        return questions;
    }

    public Question getQuestionById(Long questionId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Question  question = (Question)session.get(Question.class, questionId);
        session.getTransaction().commit();
        return question;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
