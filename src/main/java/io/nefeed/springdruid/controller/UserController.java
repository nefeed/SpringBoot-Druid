package io.nefeed.springdruid.controller;

import io.nefeed.springdruid.aspect.AnalysisActuatorAspect;
import io.nefeed.springdruid.entity.User;
import io.nefeed.springdruid.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author 章华隽
 * @mail nefeed@163.com
 * @time 2018-03-09 16:58
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 日志文件
     */
    final static Logger log = LoggerFactory.getLogger(AnalysisActuatorAspect.class);

    /**
     * 登录
     *
     * @param user
     *
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public String login(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User currentUser = (User) session.getAttribute("currentUser");
        if (currentUser != null) {
            return "You have logined already, " + currentUser.getUserName() + "!";
        }
        User resultUser = userService.login(user);
        log.info("request: user/login , user: " + user.toString());
        if (resultUser == null) {
            return "login failed";
        } else {
            session.setAttribute("currentUser", resultUser);
            return "login success";
        }
    }

    /**
     * 退出系统
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/logout")
    @ResponseBody
    public String logout(HttpSession session) throws Exception {
        session.invalidate();
        log.info("request: user/logout");
        return "logout success";
    }
}