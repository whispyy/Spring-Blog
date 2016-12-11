package blog.controllers;

import blog.Service.UserService;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @RequestMapping("/profile/{user}")
    public String profile(@PathVariable("user") String user, Model model){

        model.addAttribute("userName", user);
        return "profile";
    }

}
