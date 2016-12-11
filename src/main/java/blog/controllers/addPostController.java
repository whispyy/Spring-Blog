package blog.controllers;

import blog.Service.PostService;
import blog.Service.UserService;
import blog.forms.addPostForm;
import blog.models.Post;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by jf on 11/12/16.
 */

@Controller
public class addPostController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    @RequestMapping("/addPost")
    public String addPost(@Valid addPostForm postForm, BindingResult br, HttpSession session, Model model){
        if (br.hasErrors()) {
            return "/addPost";
        }
        //Retrieve the user if logged in;
        User user = (User) session.getAttribute("userLogged");
        if (user != null)
            model.addAttribute("userLogged", user);

        Post post = new Post(postForm.getTitle(), postForm.getBody());
        post.setAuthor(user);
        postService.create(post);

        return "/";
    }
}
