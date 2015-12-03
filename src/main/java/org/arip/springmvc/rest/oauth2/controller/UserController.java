package org.arip.springmvc.rest.oauth2.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.arip.springmvc.rest.oauth2.model.User;
import org.arip.springmvc.rest.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    private Gson gson = new GsonBuilder().create();

    @ResponseBody
    @RequestMapping(value = "/api/user", method = RequestMethod.GET)
    public String findAll(HttpServletRequest servletRequest) {

        List<User> list = userService.findAll();

        return gson.toJson(list);
    }
}