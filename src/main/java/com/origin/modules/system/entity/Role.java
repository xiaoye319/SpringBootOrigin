package com.origin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.origin.common.base.BaseEntity;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description:  角色实体类
 * @Author: yelei
 * @Date: 2019/7/26
 */

@Data
@TableName("sys_role")
public class Role extends BaseEntity implements Serializable {

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

    /**
     * 删除标识（0：正常；1：逻辑删除）
     */
    private int delFlag;
}
