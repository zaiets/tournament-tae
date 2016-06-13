package controllers;

import models.entity.site.User;
import models.repositories.abstractdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/1")
    public void test1() {
        System.out.println("~~~~~~~~~~~~~~~~~~");
        User user = new User();
        user.setLogin("tester");
        user.setPassword("111");
        user.setId(userDao.create(user));
        System.out.println(user);
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public void test2() {
        System.out.println("test 2");
    }
}

