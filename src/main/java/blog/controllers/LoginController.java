package blog.controllers;

import blog.Service.UserService;
import blog.forms.LoginForm;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
    public String loginPage(@Valid LoginForm loginForm, BindingResult br, HttpSession session) {
        if (br.hasErrors()) {
            return "/login";
        }

        User user;
        for (int i=0; i < userService.findAll().size(); i++){
            if (userService.findAll().get(i).getUsername().equals(loginForm.getUsername())) {
                user = userService.findAll().get(i);
                if (user.getPasswordHash().equals(loginForm.getPassword())) {
                    session.setAttribute("userLogged", user);
                    return "/";
                }
            }
        }
        return "/login";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("userLogged");
        return "/";
    }
}
