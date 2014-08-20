package pl.homar.config.persistance;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Bean;


/**
 * Created by Konrad on 8/19/2014.
 */
@org.springframework.context.annotation.Configuration
public class PersistanceConfig {

    @Bean
    public SessionFactory sessionFactory(){
        Configuration cfg = new Configuration()
        .addAnnotatedClass(pl.homar.entity.Question.class)
        .addAnnotatedClass(pl.homar.entity.Answer.class)
        .setProperty("hibernate.connection.driver_class", "org.postgresql.Driver")
        .setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/Testy")
        .setProperty("hibernate.connection.username", "postgres")
        .setProperty("hibernate.connection.password", "pass")
        .setProperty("hibernate.connection.pool_size", "10")
        .setProperty("show_sql", "true")
        .setProperty("dialect", "org.hibernate.dialect.PostgreSQLDialect")
        .setProperty("hibernate.hbm2ddl.auto", "update");
        return cfg.buildSessionFactory();
    }
}
