package com.origin.modules.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.origin.modules.system.dao.MenuMapper;
import com.origin.modules.system.entity.Menu;
import com.origin.modules.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: 菜单实现类
 * @Author: yelei
 * @Date: 2019/7/26
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    /**
     * @Description: 查询用户对应的菜单权限
     * @Author: yelei
     * @Date: 2019/7/26
     */
    public List<Menu> findUserPermissions(int userId){
        return menuMapper.findUserPermissions(userId);
    }
}
