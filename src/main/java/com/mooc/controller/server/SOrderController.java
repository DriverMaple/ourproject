package com.mooc.controller.server;

import com.mooc.common.RequestUtil;
import com.mooc.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by Maple on 2017/2/14.
 */
@Controller
@RequestMapping("/server/order")
public class SOrderController {
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/get_history",method = RequestMethod.GET)
    public void getHistory(HttpServletRequest req, Model model){
        Long id  = RequestUtil.getLongValueMust(req,"id");
        Byte uType = RequestUtil.getByteValueMust(req,"user_type");
        Map<String,Object> result = orderService.getHistory(id,uType);
        model.addAllAttributes(result);
    }
}
