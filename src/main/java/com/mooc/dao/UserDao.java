package com.mooc.dao;

import com.mooc.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface UserDao {
    int deleteByPrimaryKey(Long userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByTelphone(Long telephone);

    User selectByTelAndPw(Map<String,Object> map);
}