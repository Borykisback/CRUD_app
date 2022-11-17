package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.Locale;

@Controller
public class AddController {


    private final UserService userService;

    @Autowired
    public AddController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/")
    public String formList(Locale locale, Model model) {
        model.addAttribute("userList", userService.listUsers());
        return "index";
    }

    @GetMapping(value = "/addUser")
    public String form(Model model) {
        model.addAttribute("addUser", new User());
        return "addUser";
    }

    @PostMapping(value = "/UserAdd")
    public String addUser(@ModelAttribute User user) {
        userService.add(new User(user.getFirstName(), user.getLastName(), user.getAge()));
        return "redirect:/";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user.getId(), user.getFirstName(), user.getLastName(), user.getAge());
        return "redirect:/";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@ModelAttribute User user) {
        userService.delete(user.getId());
        return "redirect:/";
    }

}
