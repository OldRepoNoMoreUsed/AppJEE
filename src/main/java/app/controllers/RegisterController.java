package app.controllers;

import app.forms.RegisterForm;
import app.services.NotificationService;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notifyService;

    @RequestMapping("/users/register")
    public String register(RegisterForm registerForm){
        return "users/register";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String registerPage(@Valid RegisterForm registerForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            notifyService.addErrorMessage("Please fill the form correctly!");
            return "users/register";
        }

        if (!userService.register(
                registerForm.getUsername(), registerForm.getPassword(), registerForm.getEmail())) {
            notifyService.addErrorMessage("Invalid login!");
            return "users/register";
        }

        notifyService.addInfoMessage("Register successful");
        return "redirect:/";
    }
}