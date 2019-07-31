package com.origin.modules.system.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.origin.modules.system.entity.Role;

import java.util.List;

/**
 * @Description: 角色Mppaer
 * @Author: yelei
 * @Date: 2019/7/26
 */
public interface RoleMapper extends BaseMapper<Role> {

    /**
     * @Description: 查找用户对应的角色
     * @Author: yelei
     * @Date: 2019/7/26
     */
    List<Role> findUserRole(int userId);

}
