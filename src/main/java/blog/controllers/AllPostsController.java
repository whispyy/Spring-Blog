package blog.controllers;

import blog.Service.PostService;
import blog.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String posts(Model model) {
        List<Post> allPosts = postService.findAll();
        model.addAttribute("allPosts", allPosts);
        return "posts";
    }
}
