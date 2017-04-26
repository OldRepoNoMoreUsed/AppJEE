package app.controllers;

import app.forms.SearchForm;
import app.models.Skill;
import app.models.User;
import app.services.NotificationService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        List<User>users = userService.findAll();
        if(users == null){
            notifyService.addErrorMessage("Cannot find any user");
            return "redirect:/users";
        }
        model.addAttribute("users", users);
        return "users/users";
    }

    @RequestMapping("/users/view/{id}")
    public String view(@PathVariable("id") long id, Model model) {
        User user = userService.findById(id);
        String email = user.getemail();
        User current = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(current == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        if (user == null) {
            notifyService.addErrorMessage("Cannot find user #" + id);
            return "redirect:/";
        }
        model.addAttribute("user", user);
        model.addAttribute("current", current);
        model.addAttribute("email", email);
        model.addAttribute("skills", userService.findAllSkill());
        return "users/view";
    }

    @RequestMapping(value = "/users/search", method = RequestMethod.POST)
    public String search(Model model, SearchForm searchForm){
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        List<User>users = userService.findByName(searchForm.getSearchTerm());
        if(users == null){
            notifyService.addErrorMessage("Cannot find any user");
            return "redirect:/";
        }
        model.addAttribute("users", users);
        return "users/users";
    }

    @RequestMapping(value = "/users/view/{id}/skills", method = RequestMethod.POST)
    public String usersAddSkill(@PathVariable Long id, @RequestParam Long skillId, Model model){
        Skill skill = userService.findOneSkill(skillId);
        User user = userService.findOneUser(id);
        User current = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(current == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        if(user != null){
            if(!user.hasSkill(skill)){
                user.getSkills().add(skill);
            }
            userService.save(user);
            model.addAttribute("current", current);
            model.addAttribute("user", userService.findOneUser(id));
            model.addAttribute("email", user.getemail());
            model.addAttribute("skills", userService.findAllSkill());
            return "redirect:/users/view/" + user.getId();
        }
        model.addAttribute("users", userService.findAll());
        return "redirect:/users";
    }

}
