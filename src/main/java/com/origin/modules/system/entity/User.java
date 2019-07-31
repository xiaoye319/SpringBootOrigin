package com.origin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.origin.common.base.BaseEntity;
import lombok.Data;

/**
 * @Description:  用户实体类
 * @Author: yelei
 * @Date: 2019/7/26
 */

@Data
@TableName("sys_user")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private Integer userId;

    /**
     * 真实名称
     */
    private String userName;

    /**
     * 用户类型 0:系统用户，1:临时用户
     */
    private Integer userType;

    /**
     * 部门编号
     */
    private Integer deptId;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 联系方式
     */
    private String phone;

    /**
     * 性别
     */
    private Integer sex;

    /**
     * 排序号
     */
    private Integer sort;

    /**
     * 状态
     */
    private Integer status;

}
