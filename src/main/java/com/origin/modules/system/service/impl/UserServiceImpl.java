package com.origin.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.modules.system.dao.UserMapper;
import com.origin.modules.system.entity.User;
import com.origin.modules.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description: 用户实现类
 * @Author: yelei
 * @Date: 2019/7/26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    public User findByName(String userName){
        QueryWrapper<User>  queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(true,"user_name",userName);
        User user = userMapper.selectOne(queryWrapper);
        return user;
    }

}
