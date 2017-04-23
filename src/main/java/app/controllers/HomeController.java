package app.controllers;

import app.models.Post;
import app.services.PostService;
//import app.services.PostServiceStubImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;


@Controller
public class HomeController {

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model){
        List<Post>latest5Posts = postService.findLatest5();
        model.addAttribute("latest5Posts", latest5Posts);

        List<Post>latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = "Hello " + auth.getName() + " !";
        model.addAttribute("username", name);
        return "index";
    }

}
