package com.jchmielewski.pks.controller;

import com.jchmielewski.pks.DAO.UserDAO;
import com.jchmielewski.pks.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class test {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/")
    public void test(){

        User user = new User();
        user.setUsername("test");
        user.setPassword("test");

        userDAO.saveOrUpdate(user);

    }
}
