package ru.dkovkov.pp_3_1_2_sptingboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.dkovkov.pp_3_1_2_sptingboot.model.User;
import ru.dkovkov.pp_3_1_2_sptingboot.service.UserService;

import java.io.UnsupportedEncodingException;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String printUsers(Model model) {
        model.addAttribute("users", userService.listUser());
        return "users";
    }

    @PostMapping(value = "/users")
    public String addUser(@RequestParam(name = "name") String name,
                          @RequestParam(name = "surname") String surname,
                          @RequestParam(name = "age") Integer age) throws UnsupportedEncodingException {
        System.out.println(name);
        User user = new User(name, surname, age);
        userService.saveUser(user);
        return "redirect:users";
    }

    @DeleteMapping (value = "/{id}")
    public String deleteUser(@PathVariable(name = "id") Integer id) {
            userService.deleteUser(id);
        return "redirect:users";
    }

    @GetMapping(value = "/{id}/edit")
    public String edit(@PathVariable(name = "id") Integer id, Model model) {
        User user = userService.findUser(id);
        System.out.println(user.toString());
        model.addAttribute("user", user);
        return "edit";
    }

    @PatchMapping(value = "/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable Integer id){
        userService.updateUser(id, user);
        return "redirect:users";
    }

}
