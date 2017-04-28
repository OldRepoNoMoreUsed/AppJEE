package app.controllers;

import app.models.Post;
import app.models.Project;
import app.models.User;
import app.services.PostService;
//import app.services.PostServiceStubImpl;
import app.services.ProjectService;
import app.services.UserService;
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
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index(Model model){
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<Project>latest5Posts = projectService.findLatest5();
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
            //latest5Posts = userService.findListProject(currentUser.getId());
        }

        model.addAttribute("latest5Posts", latest5Posts);

        List<Project>latest3Posts = latest5Posts.stream().limit(3).collect(Collectors.toList());
        model.addAttribute("latest3posts", latest3Posts);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name = "Hello " + auth.getName() + " !";
        model.addAttribute("username", name);
        return "index";
    }

}
