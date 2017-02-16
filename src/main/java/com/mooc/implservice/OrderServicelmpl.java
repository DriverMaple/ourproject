package com.mooc.implservice;

import com.mooc.common.ApiContants;
import com.mooc.dao.OrderDao;
import com.mooc.entity.Order;
import com.mooc.entity.OrderExample;
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

    /**
     * 根据id与用户类型查询历史订单
     * @param id
     * @param uType
     * @return
     */
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

    /**
     * 生成订单
     * @param order
     * @return
     */
    public Map<String,Object> createOrder(Order order){
        Map<String,Object> result = new HashMap<String, Object>();
        orderDao.insertSelective(order);
        result.put("head",ApiContants.SUCCESS);
        return result;
    }

    /**
     * 根据id查找订单
     * @param order_id
     * @return
     */
    public Map<String,Object> selectById(Long order_id){
        Map<String,Object> result = new HashMap<String, Object>();
        Order order  = orderDao.selectByPrimaryKey(order_id);
        if ("".equals(order) || order == null){
            result.put("head",ApiContants.ERROR);
        }else {
            result.put("head",ApiContants.SUCCESS);
            result.put("order",order);
        }
        return result;
    }

    /**
     * 多条件查询订单
     * @param orderExample
     * @return
     */
    public Map<String,Object> selectByOrderExample(OrderExample orderExample){
        Map<String,Object> result = new HashMap<String, Object>();
        List<Order> orders = orderDao.selectByOrderExample(orderExample);
        result.put("head",ApiContants.SUCCESS);
        result.put("orders",orders);
        return result;
    }


}
