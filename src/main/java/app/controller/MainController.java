package app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MainController {

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("message", "HELLO !!!");
        return "home";
    }

}
