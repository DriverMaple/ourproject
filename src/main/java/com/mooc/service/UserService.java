package com.mooc.service;

import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */
public interface UserService {
    
    Map<String,Object> login(Long tel,String pw);
    Map<String,Object> register(Long tel,String pw,Byte type);

    Map<String,Object> getInformation(Long telephone);
}
