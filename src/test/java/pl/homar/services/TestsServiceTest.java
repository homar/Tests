package pl.homar.services;

import org.junit.Before;
import org.junit.Test;
import pl.homar.dao.QuestionsDao;
import pl.homar.dao.TestsDao;
import pl.homar.entity.Question;

import java.util.Arrays;
import java.util.HashSet;

import static junit.framework.TestCase.assertTrue;
import static org.mockito.Matchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Konrad on 8/21/2014.
 */
public class TestsServiceTest {

    private TestsService testsService;

    @Before
    public void init(){
        testsService = new TestsService();
        QuestionsService questionsService = mock(QuestionsService.class);
        Question question = new Question();
        question.setId(1L);
        when(questionsService.getRandomQuestion()).thenReturn(question);
        testsService.setQuestionsService(questionsService);
        TestsDao testsDao = mock(TestsDao.class);
        pl.homar.entity.Test test = new pl.homar.entity.Test();
        test.setQuestions(new HashSet(Arrays.asList(question)));
        when(testsDao.createTestFromQuestions(anyList())).thenReturn(test);
        testsService.setTestsDao(testsDao);
    }

    @Test(expected= IllegalArgumentException.class)
    public void createTestWithoutAnyQuestion(){
        pl.homar.entity.Test test = testsService.createNewTest(0);
    }

    @Test
    public void createNewTestWithSizeFive(){
        pl.homar.entity.Test test = testsService.createNewTest(1);
        assertTrue(test.getQuestions().size() == 1);
    }

}
