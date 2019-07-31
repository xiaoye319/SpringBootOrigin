package com.origin.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.modules.system.dao.RoleMapper;
import com.origin.modules.system.entity.Role;
import com.origin.modules.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 角色实现类
 * @Author: yelei
 * @Date: 2019/7/26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查找用户对应的角色
     */
    public List<Role> findUserRole(int userId){
        return roleMapper.findUserRole(userId);
    }
}
