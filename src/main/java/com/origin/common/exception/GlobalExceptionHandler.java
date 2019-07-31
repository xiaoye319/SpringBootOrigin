package com.origin.common.exception;

import com.alibaba.fastjson.JSONObject;
import com.origin.common.base.BaseResBean;
import com.origin.common.constants.SysConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 全局异常处理
 * @Author: yelei
 * @Date: 2019/7/26
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    /**
     * 自定义异常统一处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = ExceptionError.class)
    @ResponseBody
    public BaseResBean customExceptionInfo(HttpServletRequest request, ExceptionError e){
        BaseResBean b = new BaseResBean();
        b.setCode(e.getCode());
        b.setMessage(e.getMsg());
        log.info("错误信息-->" + JSONObject.toJSONString(b));
        return b;
    }

    /**
     * 运行时异常统一处理
     * @param request
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public BaseResBean runtimeExceptionInfo(HttpServletRequest request, RuntimeException e){
        BaseResBean b = new BaseResBean();
        b.setCode(SysConstants.RUNNINGEXCEPTIOIN_CODE);
        b.setMessage(SysConstants.RUNNINGEXCEPTIOIN_MSG);
        e.printStackTrace();
        log.info(request.getRequestURI() + "接口异常:" + e.getMessage());
        log.info("返回结果-->" + JSONObject.toJSONString(b));
        return b;
    }
}