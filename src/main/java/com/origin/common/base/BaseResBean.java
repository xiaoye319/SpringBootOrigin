package com.origin.common.base;

import com.origin.common.constants.SysConstants;
import lombok.Data;

import java.io.Serializable;

/**
 * @Description: 统一返回的Bean
 * @Author: yelei
 * @Date: 2019/7/26
 */
@Data
public class BaseResBean implements Serializable {

    private static final long serialVersionUID = -2900447975545013981L;
    private String code = SysConstants.SUCCESS_CODE;
    private String message = SysConstants.SUCCESS_MSG;
    private Object data;
}
