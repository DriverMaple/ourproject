package com.mooc.dao;

import com.mooc.entity.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDao {
    int deleteByPrimaryKey(Long orderId);

    int insert(Order record);

    int insertSelective(Order record);
}