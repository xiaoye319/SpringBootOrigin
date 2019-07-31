package com.origin.modules.system.controller;

import com.origin.common.base.BaseController;
import com.origin.modules.system.entity.Menu;
import com.origin.modules.system.service.MenuService;
import com.origin.modules.system.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Description: 登录Controller
 * @Author: yelei
 * @Date: 2019/7/29
 */
@Controller
public class LoginController extends BaseController {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;
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
    public String login(String username, String password, String code, Boolean rememberMe, Model model, HttpServletRequest request) {
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
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        try {
//            Subject subject = SecurityUtils.getSubject();
//            if (subject != null){
//                subject.logout();
//            }
//            subject.login(token);
//            userService.updateLoginTime(username);
//
//            // 获取用户权限集
//            List<Menu> permissionList = menuService.findUserPermissions(userId);
//            model.addAttribute("permissionList",permissionList);

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
//
//    @RequestMapping("/")
//    public String redirectIndex() {
//        return "redirect:/index";
//    }
//
//    @GetMapping("/403")
//    public String forbid() {
//        return "403";
//    }
//
//    @RequestMapping("/index")
//    public String index(Model model) {
//        // 登录成后，即可通过 Subject 获取登录的用户信息
////        User user = super.getCurrentUser();
////        model.addAttribute("user", user);
//        return "index";
//    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

}
