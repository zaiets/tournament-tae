package controllers;

import models.entity.site.User;
import models.repositories.abstractdao.UserDao;
import models.repositories.daoimpl.UserDaoImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    UserDao userDao = new UserDaoImpl();

    @RequestMapping(value = "/1")
    public void test1() {
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

