package pl.homar.services;

import pl.homar.dao.TestsDao;
import pl.homar.entity.Question;
import pl.homar.entity.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konrad on 8/21/2014.
 */
public class TestsService {

    private QuestionsService questionsService;
    private TestsDao testsDao;

    public Test createNewTest(int size){
        if(size < 1){
            throw new IllegalArgumentException();
        }
        List<Question> questions = new ArrayList<Question>();
        while(questions.size() < size){
            Question question = questionsService.getRandomQuestion();
            if(!questions.contains(question)) {
                questions.add(question);
            }
        }
        Test test = testsDao.createTestFromQuestions(questions);
        return test;
    }

    public void setQuestionsService(QuestionsService questionsService) {
        this.questionsService = questionsService;
    }

    public void setTestsDao(TestsDao testsDao) {
        this.testsDao = testsDao;
    }
}
