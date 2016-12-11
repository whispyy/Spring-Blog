package blog.controllers;

import blog.Service.UserService;
import blog.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jf on 10/12/16.
 */

@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(LoginForm loginForm) {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult br) {
        if (br.hasErrors()) {
            return "/login";
        }


        return "redirect:/";
    }
}
