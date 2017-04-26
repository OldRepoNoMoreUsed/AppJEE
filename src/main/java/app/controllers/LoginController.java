package app.controllers;

import app.forms.LoginForm;
import app.models.User;
import app.services.NotificationService;
import app.services.SecurityService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/login")
    public String login(LoginForm loginForm, Model model) {
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginPage(@Valid LoginForm loginForm, BindingResult bindingResult, Model model) {
        User currentUser = userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        if(currentUser == null){
            model.addAttribute("islog", false);
        }
        else{
            model.addAttribute("islog", true);
        }

        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "login";
        }

        if (!userService.authenticate(

                loginForm.getUsername(), loginForm.getPassword())) {
            notifyService.addErrorMessage("Invalid login!");
            return "login";
        }

        notifyService.addInfoMessage("Login successful");
        return "redirect:/";
    }
}

