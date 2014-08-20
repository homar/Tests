package pl.homar.services;

import org.junit.Before;
import org.junit.Test;
import pl.homar.dao.QuestionsDao;
import pl.homar.entity.Answer;
import pl.homar.entity.Question;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Konrad on 8/20/2014.
 */
public class QuestionsServiceTest {

    private QuestionsService questionsService;
    private static final String QUESTION_TEXT = "what is your name?";
    private static final String ANSWER = "konrad";

    @Before
    public void init(){
        questionsService = new QuestionsService();
        QuestionsDao questionsDao = mock(QuestionsDao.class);
        Question question = new Question();
        question.setText(QUESTION_TEXT);
        Answer answer = new Answer();
        answer.setText(ANSWER);
        answer.setQuestion(question);
        question.setAnswers(Arrays.asList(answer));
        when(questionsDao.getAllQuestions()).thenReturn(Arrays.asList(question, question));
        when(questionsDao.getQuestionById(anyLong())).thenReturn(question);
        questionsService.setQuestionsDao(questionsDao);
    }

    @Test
    public void getRandomQuestionReturnsOneCorrectQuestion(){
        Question question = questionsService.getRandomQuestion();
        assertTrue(question.getText().equals(QUESTION_TEXT));
    }

    @Test
    public void correctAnswerIsAccepted(){
        assertTrue(questionsService.checkIfCorrectAnswer(1L, ANSWER));
    }
}
