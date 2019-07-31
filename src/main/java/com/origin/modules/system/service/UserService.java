package com.origin.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.origin.modules.system.entity.User;

public interface UserService extends IService<User> {

    User findByName(String userName);
}
