package com.origin.common.exception;


import com.alibaba.fastjson.JSONObject;
import com.origin.common.base.BaseResBean;

/**
 * @Description: 自定义异常
 * @Author: yelei
 * @Date: 2019/7/26
 */
public class ExceptionError extends Exception {

    private static final long serialVersionUID = -8167269590487280495L;

    private String code;
    private String msg;

    public ExceptionError() {
        super();
    }
    public ExceptionError(String code, String message) {
        super(message);
        this.code = code;
        this.msg = message;
    }

    public BaseResBean toResBean(){
        BaseResBean b = new BaseResBean();
        b.setCode(this.code);
        b.setMessage(this.msg);
        return b;
    }

    @Override
    public String toString(){
        BaseResBean b = new BaseResBean();
        b.setCode(this.code);
        b.setMessage(this.msg);
        return JSONObject.toJSONString(b);
    }

    public String getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
