package com.origin.common.utils;

import com.origin.modules.system.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * @Description: 用户信息工具类
 * @Author: yelei
 * @Date: 2019/7/31
 */
public class UserUtils {

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static User getCurrentUser() {
        return (User) getSubject().getPrincipal();
    }

    public static Session getSession() {
        return getSubject().getSession();
    }

    public static Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    public static void login(AuthenticationToken token) {
        getSubject().login(token);
    }
}
