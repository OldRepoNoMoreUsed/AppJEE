package app.controllers;

import app.forms.CreatePostForm;
import app.forms.SearchForm;
import app.models.Post;
import app.models.Project;
import app.models.User;
import app.services.NotificationService;
import app.services.PostService;
import app.services.ProjectService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/projects/projects")
    public String index(Model model){
        List<Project>projects = projectService.findAll();
        if(projects == null){
            notifyService.addErrorMessage("Cannot find any project");
            return "redirect:/projects";
        }
        model.addAttribute("projects", projects);
        return "projects/projects";
    }

    @RequestMapping("/projects/view/{id}")
    public String view(@PathVariable("id") long id, Model model, CreatePostForm createPostForm){
        Project project = projectService.findById(id);
        if(project == null){
            notifyService.addErrorMessage("Cannot find project #" + id);
            return "redirect:/";
        }
        model.addAttribute("project", project);

        Project p = projectService.findById(id);
        List<Post> posts = postService.findByProject(p);
        if(posts == null){
            notifyService.addErrorMessage("Cannot find posts");
            return "redirect:/";
        }
        model.addAttribute("posts", posts);
        return "projects/view";
    }

    @RequestMapping(value = "/projects/view/{id}", method = RequestMethod.POST)
    public String viewPage(@Valid CreatePostForm createPostForm, BindingResult bindingResult, @PathVariable("id") long id, Model model) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "projects/view";
        }
        User current = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        Project project = projectService.findById(id);
        if(project == null){
            notifyService.addErrorMessage("Cannot find project #" + id);
            return "redirect:/";
        }

        Post post = new Post(createPostForm.getTitle(), createPostForm.getBody(), current, project);
        postService.create(post);
        notifyService.addInfoMessage("Post created");

        model.addAttribute("project", project);

        List<Post> posts = postService.findByProject(project);
        if(posts == null){
            notifyService.addErrorMessage("Cannot find posts");
            return "redirect:/";
        }
        model.addAttribute("posts", posts);
        return "projects/view";
    }

    //@RequestMapping("/projects/search")
    @RequestMapping(value = "/projects/search", method = RequestMethod.POST)
    public String search(Model model, SearchForm searchForm){
        List<Project>projects = projectService.findByName(searchForm.getSearchTerm());
        //searchForm.getSearchTerm()
        if(projects == null){
            notifyService.addErrorMessage("Cannot find any project");
            return "redirect:/projects/projects";
        }
        model.addAttribute("projects", projects);
        return "projects/projects";
    }
}