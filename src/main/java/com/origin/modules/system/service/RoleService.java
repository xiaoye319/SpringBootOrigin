package com.origin.modules.system.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.origin.modules.system.entity.Role;

import java.util.List;

public interface RoleService extends IService<Role> {

    List<Role> findUserRole(int userId);

}
