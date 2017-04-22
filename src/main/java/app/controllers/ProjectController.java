package app.controllers;

import app.models.Project;
import app.services.NotificationService;
import app.services.PostService;
import app.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by mega- on 22.04.2017.
 */
@Controller
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/projects/view/{id}")
    public String view(@PathVariable("id") long id, Model model){
        Project project = projectService.findById(id);
        if(project == null){
            notifyService.addErrorMessage("Cannot find project #" + id);
            return "redirect:/";
        }
        model.addAttribute("project", project);
        return "projects/view";
    }

    @RequestMapping("/projects/search")
    public String search(Model model){
        List<Project>projects = projectService.findAll();
        if(projects == null){
            notifyService.addErrorMessage("Cannot find any project");
            return "redirect:/";
        }
        model.addAttribute("projects", projects);
        return "projects/search";
    }
}
