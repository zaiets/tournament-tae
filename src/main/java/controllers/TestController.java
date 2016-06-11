package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import service.WeightCategoryService;

@RestController
public class TestController {
    @Autowired
    WeightCategoryService weightCategoryService;

    @RequestMapping(value = "/1", method = RequestMethod.GET)
    public void test1() {
        System.out.println("test 1");
    }

    @RequestMapping(value = "/2", method = RequestMethod.GET)
    public void test2() {
        System.out.println("test 2");
    }
}

