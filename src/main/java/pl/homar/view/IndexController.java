package pl.homar.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.homar.dao.QuestionsDao;
import pl.homar.entity.Question;
import pl.homar.entity.Test;
import pl.homar.services.QuestionsService;
import pl.homar.services.TestsService;

/**
 * Created by Konrad on 8/18/2014.
 */
@Controller
public class IndexController {

    @Autowired
    QuestionsService questionsService;

    @Autowired
    TestsService testsService;

    @RequestMapping("/dupa")
    @ResponseBody
    public String index(){
        Question question = questionsService.createNewQuestion("What is dupa?", "dupa is dupa");
        Test test = testsService.createNewTest(3);
        return questionsService.checkIfCorrectAnswer(question.getId(), "dupa is dupa") + " " + test.getQuestions().size();
    }
}
