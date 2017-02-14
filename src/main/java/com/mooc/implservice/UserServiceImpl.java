package com.mooc.implservice;

import com.mooc.common.ApiContants;
import com.mooc.dao.UserDao;
import com.mooc.entity.User;
import com.mooc.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Zhangxq on 2016/7/15.
 */

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    
    public User getUser(Long id) {
        return userDao.selectByPrimaryKey(id);
    }

    /**
     * 登录
     * @param tel
     * @param pw
     * @return
     */
    public Map<String,Object> login(Long tel,String pw){
        Map<String,Object> result = new HashMap<String, Object>();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("telephone",tel);
        map.put("password",pw);
        User user = userDao.selectByTelAndPw(map);
        if ("".equals(user) || user == null){
            result.put("head", ApiContants.ERROR);
        }else{
            result.put("head",ApiContants.SUCCESS);
        }
        return result;
    }

    /**
     * 注册
     * @param tel
     * @param pw
     * @return
     */
    public Map<String,Object> register(Long tel,String pw){
        Map<String,Object> result = new HashMap<String, Object>();
        User test = userDao.selectByTelphone(tel);
        //存在返回错误，不存在插入数据
        if ("".equals(test) || test == null){
            User user = new User();
            user.setTelephone(tel);
            user.setPassword(pw);
            userDao.insert(user);
            result.put("head",ApiContants.SUCCESS);
        }else{
            result.put("head",ApiContants.ERROR);
        }
        return result;
    }
}
