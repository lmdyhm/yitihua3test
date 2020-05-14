package cn.edu.nenu.controller;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletRequest;

/**
 * LoginController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2020-03-04 22:05
 */
@CommonsLog
@Controller
//@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = {"/index","/"},method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String loginForm(){
        return "login";
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(ServletRequest request, Model model){
        String username = request.getParameter("username");
        log.info(username);
        model.addAttribute("username",username);
        return "loginsuccess";
    }
}
