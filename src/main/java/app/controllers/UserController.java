package app.controllers;

import app.forms.SearchForm;
import app.models.Project;
import app.models.User;
import app.services.NotificationService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by mega- on 24.04.2017.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping(value = "/users")
    public String index(Model model){
        List<User>users = userService.findAll();
        if(users == null){
            notifyService.addErrorMessage("Cannot find any project");
            return "redirect:/users";
        }
        model.addAttribute("users", users);
        return "users/users";
    }

    @RequestMapping("/users/view/{id}")
    public String view(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        String email = user.getemail();
        if (user == null) {
            notifyService.addErrorMessage("Cannot find user #" + id);
            return "redirect:/";
        }
        model.addAttribute("user", user);
        model.addAttribute("email", email);
        return "users/view";
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public String search(Model model, SearchForm searchForm){
        List<User>users = userService.findByName(searchForm.getSearchTerm());
        if(users == null){
            notifyService.addErrorMessage("Cannot find any user");
            return "redirect:/";
        }
        model.addAttribute("users", users);
        return "users/users";
    }
}
