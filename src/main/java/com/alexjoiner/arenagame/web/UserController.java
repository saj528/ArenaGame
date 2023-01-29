package com.alexjoiner.arenagame.web;

import com.alexjoiner.arenagame.domain.User;
import com.alexjoiner.arenagame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String getUser (ModelMap modelMap){
        List<User> users = userService.findAll();
        modelMap.put("users",users);
        return "users";
    }

    @GetMapping("/add-user")
    public String createUser(ModelMap modelMap){
        modelMap.put("user",new User());
        return "add-user";
    }

    @PostMapping("/add-user")
    public String createUser(User user){

        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping("/users/{userId}")
    public String getOneUser(ModelMap modelMap, @PathVariable Long userId){
        User user = userService.findById(userId);

        modelMap.put("user",user);

        return "user";
    }

    @PostMapping("/update-user")
    public String updateOneUser(User user){
        userService.save(user);
        return "redirect:/users/" + user.getId();
    }


    @PostMapping("/users/{userId}/delete")
    public String deleteOneUser(@PathVariable Long userId){
        userService.delete(userId);
        return "redirect:/users";
    }



}
