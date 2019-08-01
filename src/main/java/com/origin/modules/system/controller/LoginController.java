package com.origin.modules.system.controller;

import com.origin.common.base.BaseController;
import com.origin.common.utils.UserUtils;
import com.origin.modules.system.entity.Menu;
import com.origin.modules.system.entity.User;
import com.origin.modules.system.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description: 登录Controller
 * @Author: yelei
 * @Date: 2019/7/29
 */
@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MenuService menuService;

    /**
     * 跳转登录页面
     */
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * 登录认证
     */
    @PostMapping("/login")
    public String login(String userName, String password, String code, Boolean rememberMe, Model model, HttpServletRequest request) {
//        if (!StringUtils.isNotBlank(code)) {
//            return ResponseBo.warn("验证码不能为空！");
//        }
//        Session session = super.getSession();
//        String sessionCode = (String) session.getAttribute(CODE_KEY);
//        if (!code.equalsIgnoreCase(sessionCode)) {
//            return ResponseBo.warn("验证码错误！");
//        }
        // 密码 MD5 加密
//        password = MD5Utils.encrypt(username.toLowerCase(), password);
        rememberMe = WebUtils.isTrue(request, FormAuthenticationFilter.DEFAULT_REMEMBER_ME_PARAM);
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password, rememberMe);
        try {
            Subject subject = SecurityUtils.getSubject();
            if (subject != null){
                subject.logout();
            }
            subject.login(token);

        } catch (UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            request.setAttribute("msg", "账户信息异常");
            return "login";
        } catch (AuthenticationException e) {
            request.setAttribute("msg","认证失败！");
            return "login";
        }
        // 执行到这里说明用户已登录成功
        return "redirect:/index";
    }

    /**
     * 跳转登录页面
     */
    @RequestMapping("/index")
    public String index(Model model) {
        User user = UserUtils.getCurrentUser();
        if (user != null) {
            // 获取用户能访问的菜单
            List<Menu> menus = menuService.findUserPermissions(user.getUserId());
            model.addAttribute("menus",menus);
            model.addAttribute("user", user);
            return "index";
        } else {
            return "login";
        }
    }

    /**
     * 退出登录
     */
    @RequestMapping("/logout")
    public String logout(Model model) {
        Subject subject = SecurityUtils.getSubject();
        if (subject != null){
            subject.logout();
        }
        return "redirect:/login";
    }

    /**
     * 空白页跳转
     */
    @RequestMapping("/")
    public String common() {
        return "redirect:/index";
    }

//    @GetMapping(value = "gifCode")
//    public void getGifCode(HttpServletResponse response, HttpServletRequest request) {
//        try {
//            response.setHeader("Pragma", "No-cache");
//            response.setHeader("Cache-Control", "no-cache");
//            response.setDateHeader("Expires", 0);
//            response.setContentType("image/gif");
//
////            Captcha captcha = new GifCaptcha(
////                    febsProperties.getValidateCode().getWidth(),
////                    febsProperties.getValidateCode().getHeight(),
////                    febsProperties.getValidateCode().getLength());
////            HttpSession session = request.getSession(true);
////            captcha.out(response.getOutputStream());
////            session.removeAttribute(CODE_KEY);
////            session.setAttribute(CODE_KEY, captcha.text().toLowerCase());
////            System.out.println("验证码：-----------"+(String) session.getAttribute(CODE_KEY));
////            System.out.println("验证码的sessionId：-----------"+ session.getId());
//        } catch (Exception e) {
//            log.error("图形验证码生成失败", e);
//        }
//    }
}
