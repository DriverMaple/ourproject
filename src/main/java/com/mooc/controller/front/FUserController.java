package com.mooc.controller.front;

import com.mooc.entity.User;
import com.mooc.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Controller
@RequestMapping("/front/user")
public class FUserController {

    private Logger log = Logger.getLogger(FUserController.class);
    @Resource
    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model){
        log.info("查询所有用户信息");
        User user = null;
        model.addAttribute("userList",user);
        return "showUser";
    }
}
