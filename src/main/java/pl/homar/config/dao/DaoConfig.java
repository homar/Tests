package pl.homar.config.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.homar.dao.TestDao;

/**
 * Created by Konrad on 8/19/2014.
 */
@Configuration
public class DaoConfig {

    @Autowired
    SessionFactory sessionFactory;

    @Bean
    public TestDao testDao(){
        TestDao testDao = new TestDao();
        testDao.setSessionFactory(sessionFactory);
        return testDao;
    }

}
