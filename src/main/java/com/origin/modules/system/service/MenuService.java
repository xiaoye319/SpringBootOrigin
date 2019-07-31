package com.origin.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.origin.modules.system.entity.Menu;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<Menu> findUserPermissions(int userId);
}
