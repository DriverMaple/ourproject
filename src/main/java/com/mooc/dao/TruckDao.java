package com.mooc.dao;

import com.mooc.entity.Truck;
import org.springframework.stereotype.Repository;

@Repository
public interface TruckDao {
    int deleteByPrimaryKey(Long truckId);

    int insert(Truck record);

    int insertSelective(Truck record);

    Truck selectByPrimaryKey(Long truckId);

    int updateByPrimaryKeySelective(Truck record);

    int updateByPrimaryKey(Truck record);
}