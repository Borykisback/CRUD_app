package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.Locale;

@Controller
@RequestMapping(value = "/users")
public class AddController {


    private final UserService userService;

    @Autowired
    public AddController(UserService userService) {
        this.userService = userService;
    }


    //******************* index

    @GetMapping()
    public String formList(Model model) {
        model.addAttribute("userList", userService.listUsers());
        model.addAttribute("addNewUser", new User());
        return "users/index";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("addNewUser") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    //******************* index


    //******************* editUser

    @GetMapping(value = "/{id}/editUser")
    public String formEdit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("userId", userService.show(id));
        return "users/editUser";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("userId") User user, @PathVariable("id") Long id) {
        userService.update(user, id);
        return "redirect:/users";
    }


    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

    //******************* editUser

}
