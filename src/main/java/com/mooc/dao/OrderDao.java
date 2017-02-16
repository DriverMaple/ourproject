package com.mooc.dao;

import com.mooc.entity.Order;
import com.mooc.entity.OrderExample;

import java.util.List;

public interface OrderDao {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    List<Order> selectByOrder(Order order);

    List<Order> selectByOrderExample(OrderExample orderExample);
}