package com.origin.common.base;

import lombok.Data;

import java.util.Date;

/**
 * @Description: 基础实体类
 * @Author: yelei
 * @Date: 2019/7/26
 */
@Data
public class BaseEntity {

    /**
     * 创建者ID
     */
    protected Long createBy;

    /**
     * 创建时间
     */
    protected Date createTime;

    /**
     * 修改者ID
     */
    protected Long updateBy;

    /**
     * 修改时间
     */
    protected Date updateTime;

}
