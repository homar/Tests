package pl.homar.config.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.homar.dao.QuestionsDao;
import pl.homar.dao.TestsDao;

/**
 * Created by Konrad on 8/19/2014.
 */
@Configuration
public class DaoConfig {

    @Autowired
    SessionFactory sessionFactory;

    @Bean
    public QuestionsDao questionsDao(){
        QuestionsDao questionsDao = new QuestionsDao();
        questionsDao.setSessionFactory(sessionFactory);
        return questionsDao;
    }

    @Bean
    public TestsDao testsDao(){
        TestsDao testsDao = new TestsDao();
        testsDao.setSessionFactory(sessionFactory);
        return testsDao;
    }
}
