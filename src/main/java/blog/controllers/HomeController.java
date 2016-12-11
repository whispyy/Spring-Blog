package blog.controllers;

import blog.Service.PostService;
import blog.Service.UserService;
import blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jf on 09/12/16.
 */
@Controller
public class HomeController {
    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model) {
        List<Post> latest5Posts = postService.findAll().stream()
                .limit(5).collect(Collectors.toList());
        model.addAttribute("latest5posts", latest5Posts);

        model.addAttribute("users", userService.findAll());

        return "index";
    }
}
