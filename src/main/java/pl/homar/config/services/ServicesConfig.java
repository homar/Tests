package pl.homar.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.homar.dao.QuestionsDao;
import pl.homar.services.QuestionsService;

/**
 * Created by Konrad on 8/18/2014.
 */
@Configuration
@ComponentScan(basePackages = "pl.homar")
public class ServicesConfig {

    @Autowired
    QuestionsDao questionsDao;

    @Bean
    public QuestionsService questionsService(){
        QuestionsService questionsService = new QuestionsService();
        questionsService.setQuestionsDao(questionsDao);
        return questionsService;
    }

}
