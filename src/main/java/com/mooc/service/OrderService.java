package com.mooc.service;

import java.util.Map;

/**
 * Created by Maple on 2017/2/14.
 */
public interface OrderService {

    Map<String,Object> getHistory(Long id, Byte uType);
}
