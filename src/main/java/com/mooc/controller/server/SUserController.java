package com.mooc.controller.server;

import com.mooc.common.RequestUtil;
import com.mooc.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Maple on 2017/2/12.
 */
@Controller
@RequestMapping("/server/user")
public class SUserController {
    @Resource
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public void login(HttpServletRequest req,Model model){
        Long telephone;
        String passwrod;
        telephone = RequestUtil.getLongValueMust(req,"tel");
        passwrod = RequestUtil.getStringValue(req,"pw");
        Map<String,Object> result = userService.login(telephone,passwrod);
        model.addAllAttributes(result);
    }

    /**
     * 注册
     * @param req
     * @param model
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public void register(HttpServletRequest req,Model model){
        Long telephone;
        String passwrod;
        Byte type;
        telephone = RequestUtil.getLongValueMust(req,"tel");
        passwrod = RequestUtil.getStringValueMust(req,"pw");
        type = RequestUtil.getByteValueMust(req,"type");
        Map<String,Object> result = userService.register(telephone,passwrod,type);
        model.addAllAttributes(result);
    }

    /**
     * 用户信息获取
     * @param req
     * @param model
     */
    @RequestMapping(value = "/get_information",method = RequestMethod.GET)
    public void getInformation(HttpServletRequest req,Model model){
        Long telephone;
        telephone = RequestUtil.getLongValueMust(req,"tel");
        Map<String,Object> result = userService.getInformation(telephone);
        model.addAllAttributes(result);
    }
}
