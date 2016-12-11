package blog.controllers;

import blog.Service.UserService;
import blog.forms.RegisterForm;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

import static org.springframework.cglib.beans.BeanMap.create;

/**
 * Created by jf on 10/12/16.
 */

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(RegisterForm registerForm) {
        return "register";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult br) {
        if (br.hasErrors()) {
            return "/register";
        }
        User user = new User(registerForm.getUsername(),registerForm.getPassword(),registerForm.getFullname());
        userService.create(user);
        System.out.println(user.toString());
        System.out.println(userService.findAll());
        //need to check if username already exists in database

        return "redirect:/";
    }
}
