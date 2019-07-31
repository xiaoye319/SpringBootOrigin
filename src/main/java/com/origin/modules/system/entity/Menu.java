package com.origin.modules.system.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.origin.common.base.BaseEntity;
import lombok.Data;

/**
 * @Description: 菜单实体类
 * @Author: yelei
 * @Date: 2019/7/26
 */

@Data
@TableName("sys_menu")
public class Menu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 菜单/按钮id
     */
    private Long menuId;

    /**
     * 上级菜单id
     */
    private Long parentId;

    /**
     * 菜单/按钮名称
     */
    private String menuName;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 权限标识
     */
    private String perms;

    /**
     * 图标
     */
    private String icon;

    /**
     * 类型 0菜单 1按钮
     */
    private String type;

    /**
     * 排序
     */
    private Long sort;
}
