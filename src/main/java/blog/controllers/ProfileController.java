package blog.controllers;

import blog.Service.PostService;
import blog.Service.UserService;
import blog.models.Post;
import blog.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ProfileController {
    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @RequestMapping("/profile/{user}")
    public String profile(@PathVariable("user") String user, Model model, HttpSession session){
        //Retrieve the user if logged in;
        User userLogged = (User) session.getAttribute("userLogged");
        if (userLogged != null){
            model.addAttribute("userLogged", userLogged);
        }

        model.addAttribute("userName", user);

        User userProfile;
        for (int i=0; i < userService.findAll().size(); i++){
            if (userService.findAll().get(i).getUsername().equals(user)) {
                userProfile = userService.findAll().get(i);
                model.addAttribute("fullName", userProfile.getFullName());
                return "profile";
            }
        }
        return "/";
    }

    @RequestMapping("profile/{user}/posts")
    public String profilePosts(@PathVariable("user") String user, Model model, HttpSession session){
        //Retrieve the user if logged in;
        User userLogged = (User) session.getAttribute("userLogged");
        if (userLogged != null)
            model.addAttribute("userLogged", userLogged);

        model.addAttribute("userName", user);
        List<Post> all = postService.findAll();
        List<String> posts = new ArrayList<String>();
        for (int i = 0; i < all.size(); i++){
            if (all.get(i).getAuthor().getUsername().equals(user)){
                posts.add(all.get(i).getBody());
            }

        }
        model.addAttribute("posts", posts);

        return "profile.posts";
    }

}
