package com.mooc.controller.server;

import com.mooc.common.ChangeCode;
import com.mooc.common.MyDateUtils;
import com.mooc.common.RequestUtil;
import com.mooc.entity.Order;
import com.mooc.entity.OrderExample;
import com.mooc.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * Created by Maple on 2017/2/14.
 */
@Controller
@RequestMapping("/server/order")
public class SOrderController {

    @Resource
    private OrderService orderService;

    /**
     * 获取历史订单
     * @param req
     * @param model
     */
    @RequestMapping(value = "/get_history",method = RequestMethod.GET)
    public void getHistory(HttpServletRequest req, Model model){
        Long id  = RequestUtil.getLongValueMust(req,"id");
        Byte uType = RequestUtil.getByteValueMust(req,"user_type");
        Map<String,Object> result = orderService.getHistory(id,uType);
        model.addAllAttributes(result);
    }

    /**
     * 发布订单
     * @param req
     * @param model
     */
    @RequestMapping(value = "public_order",method = RequestMethod.POST)
    public void publicOrder(HttpServletRequest req,Model model){
        Order order = new Order();
        Long owner_id = RequestUtil.getLongValueMust(req,"owner_id");
        String from_p = RequestUtil.getStringValue(req,"from_p");
        String to_p = RequestUtil.getStringValue(req,"to_p");
        Byte order_type = RequestUtil.getByteValueMust(req,"order_type");
        String goods_type = RequestUtil.getStringValue(req,"goods_type");
        Float goods_v = RequestUtil.getFloatValue(req,"goods_v");
        Float goods_w = RequestUtil.getFloatValue(req,"goods_w");
        Boolean is_urgent = RequestUtil.getBooleanValue(req,"is_urgent");
        Date public_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "public_t"), "yyyy-MM-dd HH:mm");
        String remarks = RequestUtil.getStringValue(req,"remarks");

        order.setOwnerId(owner_id);
        order.setFromP(from_p);
        order.setToP(to_p);
        order.setOrderType(order_type);
        order.setGoodsType(goods_type);
        order.setGoodsV(goods_v);
        order.setGoodsW(goods_w);
        order.setIsUrgent(is_urgent);
        order.setPublicT(public_t);
        order.setRemarks(remarks);
        order.setLevel((byte) 1);
        order.setState((byte) 1);

        Map<String,Object> result = orderService.createOrder(order);
        model.addAllAttributes(result);
    }

    /**
     * 拼单申请
     * @param req
     * @param model
     */
    @RequestMapping(value = "coop_order",method = RequestMethod.POST)
    public void coopOrder(HttpServletRequest req,Model model){
        Order order = new Order();

        Long driver_id = RequestUtil.getLongValueMust(req,"driver_id");
        Long owner_id = RequestUtil.getLongValueMust(req,"owner_id");
        String from_p = RequestUtil.getStringValue(req,"from_p");
        String to_p = RequestUtil.getStringValue(req,"to_p");
        Byte order_type = RequestUtil.getByteValueMust(req,"order_type");
        Long super_id = RequestUtil.getLongValueMust(req,"super_id");
        String goods_type = RequestUtil.getStringValue(req,"goods_type");
        Float goods_v = RequestUtil.getFloatValue(req,"goods_v");
        Float goods_w = RequestUtil.getFloatValue(req,"goods_w");
        Boolean is_urgent = RequestUtil.getBooleanValue(req,"is_urgent");
        Date public_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "public_t"), "yyyy-MM-dd HH:mm");
        String remarks = RequestUtil.getStringValue(req,"remarks");

        order.setDriverId(driver_id);
        order.setOwnerId(owner_id);
        order.setFromP(from_p);
        order.setToP(to_p);
        order.setOrderType(order_type);
        order.setSuperId(super_id);
        order.setGoodsType(goods_type);
        order.setGoodsV(goods_v);
        order.setGoodsW(goods_w);
        order.setIsUrgent(is_urgent);
        order.setPublicT(public_t);
        order.setRemarks(remarks);
        order.setLevel((byte) 2);
        order.setState((byte) 1);

        Map<String,Object> result = orderService.createOrder(order);
        model.addAllAttributes(result);
    }

    /**
     * 获取订单详细信息
     * @param req
     * @param model
     */
    @RequestMapping(value = "get_detail",method = RequestMethod.GET)
    public void getOrderDetail(HttpServletRequest req,Model model){
        Long order_id = RequestUtil.getLongValueMust(req,"or der_id");
        Map<String,Object> result = orderService.selectById(order_id);
        model.addAllAttributes(result);
    }

    /**
     * （司机）普通订单条件搜索
     * @param req
     * @param model
     */
    @RequestMapping(value = "get_common",method = RequestMethod.GET)
    public void getCommon(HttpServletRequest req,Model model){
        OrderExample orderExample = new OrderExample();

        String from_p = RequestUtil.getStringValue(req,"from_p");
        String to_p = RequestUtil.getStringValue(req,"to_p");
        from_p = ChangeCode.toUTF8(from_p);
        to_p = ChangeCode.toUTF8(to_p);
        Byte order_type = RequestUtil.getByteValue(req,"order_type");
        Date from_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "from_t"), "yyyy-MM-dd HH:mm");
        Date to_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "to_t"), "yyyy-MM-dd HH:mm");

        orderExample.setFromP(from_p);
        orderExample.setToP(to_p);
        orderExample.setOrderType(order_type);
        orderExample.setIsUrgent(false);
        orderExample.setFromT(from_t);
        orderExample.setToT(to_t);
        orderExample.setFlag(false);
        orderExample.setState((byte)1);

        Map<String,Object> result = orderService.selectByOrderExample(orderExample);
        model.addAllAttributes(result);
    }

    /**
     * （货主）拼单条件搜索
     * @param req
     * @param model
     */
    @RequestMapping(value = "get_scattered",method = RequestMethod.GET)
    public void getScattered(HttpServletRequest req,Model model){
        OrderExample orderExample = new OrderExample();

        String from_p = RequestUtil.getStringValue(req,"from_p");
        String to_p = RequestUtil.getStringValue(req,"to_p");
        from_p = ChangeCode.toUTF8(from_p);
        to_p = ChangeCode.toUTF8(to_p);
        Date from_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "from_t"), "yyyy-MM-dd HH:mm");
        Date to_t = MyDateUtils.parse(RequestUtil.getStringValue(req, "to_t"), "yyyy-MM-dd HH:mm");

        orderExample.setFromP(from_p);
        orderExample.setToP(to_p);
        orderExample.setOrderType((byte)0);
        orderExample.setLevel((byte)1);
        orderExample.setIsUrgent(false);
        orderExample.setFromT(from_t);
        orderExample.setToT(to_t);
        orderExample.setFlag(false);
        orderExample.setState((byte)3);

        Map<String,Object> result = orderService.selectByOrderExample(orderExample);
        model.addAllAttributes(result);
    }

    /**
     * (司机)急单获取
     * @param req
     * @param model
     */
    @RequestMapping(value = "get_urgent",method = RequestMethod.GET)
    public void getUrgent(HttpServletRequest req,Model model){
        OrderExample orderExample = new OrderExample();

        orderExample.setIsUrgent(true);
        orderExample.setFlag(false);
        orderExample.setState((byte)1);

        Map<String,Object> result = orderService.selectByOrderExample(orderExample);
        model.addAllAttributes(result);
    }
}
