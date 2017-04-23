package app.controllers;

import app.forms.CreateForm;
import app.forms.RegisterForm;
import app.models.Project;
import app.models.User;
import app.services.NotificationService;
import app.services.ProjectService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mega- on 22.04.2017.
 */
@Controller
public class CreateController {
    @Autowired
    private ProjectService projectService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/projects/create")
    public String create(CreateForm createForm){
        return "projects/create";
    }

    @RequestMapping(value = "/projects/create", method = RequestMethod.POST)
    public String createPage(@Valid CreateForm createForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "projects/create";
        }

        Project p = new Project(1L , createForm.getTitle(), createForm.getDescription(),
                new User(1L, "creation",  "creation@test.test"));

        projectService.create(p);

        notifyService.addInfoMessage("Project created");
        return "redirect:/projects/search";
    }
}