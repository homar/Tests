package pl.homar.config.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import pl.homar.dao.QuestionsDao;
import pl.homar.dao.TestsDao;
import pl.homar.services.QuestionsService;
import pl.homar.services.TestsService;

/**
 * Created by Konrad on 8/18/2014.
 */
@Configuration
@ComponentScan(basePackages = "pl.homar")
public class ServicesConfig {

    @Autowired
    QuestionsDao questionsDao;

    @Autowired
    TestsDao testsDao;

    @Bean
    public QuestionsService questionsService(){
        QuestionsService questionsService = new QuestionsService();
        questionsService.setQuestionsDao(questionsDao);
        return questionsService;
    }

    @Bean
    public TestsService testsService(){
        TestsService testsService = new TestsService();
        testsService.setTestsDao(testsDao);
        testsService.setQuestionsService(questionsService());
        return testsService;
    }
}
