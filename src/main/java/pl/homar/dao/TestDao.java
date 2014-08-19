package pl.homar.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import pl.homar.entity.Test;

/**
 * Created by Konrad on 8/19/2014.
 */
public class TestDao {

    private SessionFactory sessionFactory;

    public void createTest() {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Test t = new Test();
        session.save(t);
        session.getTransaction().commit();
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
