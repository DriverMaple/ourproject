package com.mooc.implservice;

import com.mooc.common.ApiContants;
import com.mooc.dao.OrderDao;
import com.mooc.entity.Order;
import com.mooc.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Maple on 2017/2/14.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class OrderServicelmpl implements OrderService{
    @Resource
    private OrderDao orderDao;

    public Map<String,Object> getHistory(Long id,Byte uType){
        Order order = new Order();
        Map<String,Object> result = new HashMap<String, Object>();
        if (uType == 0){
            order.setOwnerId(id);
        }else{
            order.setDriverId(id);
        }
        List<Order> orders = orderDao.selectByOrder(order);
        result.put("head", ApiContants.SUCCESS);
        result.put("order",orders);
        return result;
    }
}
