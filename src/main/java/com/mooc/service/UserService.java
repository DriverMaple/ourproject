package com.mooc.service;

import com.mooc.entity.User;

import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {

    User getUser(Long id);
    Map<String,Object> login(Long tel,String pw);
    Map<String,Object> register(Long tel,String pw);
}
