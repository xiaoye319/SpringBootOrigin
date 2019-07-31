package com.origin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.origin.common.base.BaseEntity;
import lombok.Data;

/**
 * @Description:  角色实体类
 * @Author: yelei
 * @Date: 2019/7/26
 */

@Data
@TableName("sys_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 角色id
     */
    private Long roleId;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 角色描述
     */
    private String remark;
}
