package pl.homar.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.homar.dao.TestDao;

/**
 * Created by Konrad on 8/18/2014.
 */
@Controller
public class IndexController {

    @Autowired
    TestDao testDao;

    @RequestMapping("/dupa")
    @ResponseBody
    public String index(){
        testDao.createTest();
        return "DUPA";
    }
}
