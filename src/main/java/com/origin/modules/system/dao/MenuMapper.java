package com.origin.modules.system.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.origin.modules.system.entity.Menu;

import java.util.List;

/**
 * @Description: 菜单Mapper
 * @Author: yelei
 * @Date: 2019/7/26
 */
public interface MenuMapper extends BaseMapper<Menu> {


    /**
     * @Description: 查询用户对应的菜单权限
     * @Author: yelei
     * @Date: 2019/7/26
     */
    List<Menu> findUserPermissions(int userId);

}
