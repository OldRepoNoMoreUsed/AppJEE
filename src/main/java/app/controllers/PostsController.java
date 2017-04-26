package app.controllers;

import app.models.Post;
import app.models.User;
import app.services.NotificationService;
import app.services.PostService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PostsController {
    @Autowired
    private PostService postService;

    @Autowired
    private NotificationService notifyService;

    @Autowired
    private UserService userService;

    @RequestMapping("/posts/view/{id}")
    public String view(@PathVariable("id") long id, Model model){
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        Post post = postService.findById(id);
        if(post == null){
            notifyService.addErrorMessage("Cannot find post #" + id);
            return "redirect:/";
        }
        model.addAttribute("post", post);
        return "posts/view";
    }
}
