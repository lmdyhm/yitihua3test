package cn.edu.nenu.controller;

import cn.edu.nenu.service.UserService;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletRequest;
import java.util.List;

/**
 * UserController Class
 *
 * @author <b>Oxidyc</b>, Copyright &#169; 2003
 * @version 1.0, 2020-03-04 22:54
 */
@CommonsLog
@Controller
@RequestMapping("/user")
public class UserController {

    private static final int PAGE_SIZE = 20;

    @Autowired
    public UserService userService;

    @GetMapping()
    public String list(@RequestParam(value = "page",defaultValue = "1")int pageNumber,
                       Model model, ServletRequest request){
        String param = request.getParameter("param");
        List users = userService.getPage(pageNumber,PAGE_SIZE,param);
        model.addAttribute("param",param);
        return "user/list";
    }

    @GetMapping("/create")
    public String createForm(Model model){
        return "user/form";
    }

    @PostMapping("/create")
    public String create(RedirectAttributes redirectAttributes){
        return "redirect:/user";
    }
}
