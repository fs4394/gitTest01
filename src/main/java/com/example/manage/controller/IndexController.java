package com.example.manage.controller;

import com.example.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * FileName:    IndexController
 * Author:      Yuan-Programmer
 * Date:        2021/12/4 14:27
 * Description:
 */
@RestController
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/index") // 访问路径
    public ModelAndView toIndex() {
        // 返回templates目录下index.html
        ModelAndView view = new ModelAndView("index");
        // 查询所有的用户，添加到model视图里
        view.addObject("user_list", userService.selectAllUser());
        return view;
    }
}
