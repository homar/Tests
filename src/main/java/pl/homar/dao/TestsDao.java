package pl.homar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import pl.homar.entity.Question;
import pl.homar.entity.Test;

import java.util.HashSet;
import java.util.List;

/**
 * Created by Konrad on 8/21/2014.
 */
public class TestsDao {

    private SessionFactory sessionFactory;

    public Test createTestFromQuestions(List<Question> questions){
        Test test = new Test();
        test.setQuestions(new HashSet(questions));
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(test);
        session.getTransaction().commit();
        session.close();
        return test;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
