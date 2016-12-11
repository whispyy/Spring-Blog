package blog.controllers;

import blog.Service.PostService;
import blog.models.Post;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by jf on 10/12/16.
 */
@Controller
public class AllPostsController {
    @Autowired
    private PostService postService;

    @RequestMapping("/posts")
    public String posts(Model model, HttpSession session) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        //Retrieve the user if logged in;
        User user = (User) session.getAttribute("userLogged");
        if (user != null)
            model.addAttribute("userLogged", user);
        return "posts";
    }
}
