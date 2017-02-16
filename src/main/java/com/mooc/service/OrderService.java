package com.mooc.service;

import com.mooc.entity.Order;
import com.mooc.entity.OrderExample;

import java.util.Map;

/**
 * Created by Maple on 2017/2/14.
 */
public interface OrderService {

    Map<String,Object> getHistory(Long id, Byte uType);

    Map<String,Object> createOrder(Order order);

    Map<String,Object> selectById(Long order_id);

    Map<String,Object> selectByOrderExample(OrderExample orderExample);
}
