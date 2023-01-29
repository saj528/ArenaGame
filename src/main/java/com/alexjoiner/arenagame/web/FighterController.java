package com.alexjoiner.arenagame.web;

import com.alexjoiner.arenagame.domain.Fighter;
import com.alexjoiner.arenagame.domain.User;
import com.alexjoiner.arenagame.service.FighterService;
import com.alexjoiner.arenagame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FighterController {

    @Autowired
    private FighterService fighterService;

    @Autowired
    private UserService userService;

    @GetMapping("/fighters")
    public String getAllFighters(ModelMap modelMap){
        List<Fighter> fighters = fighterService.findAll();
        modelMap.put("fighters",fighters);
        return "fighters";
    }

    @GetMapping("/add-fighter")
    public String createFighter(ModelMap modelMap){
        List<User> users = userService.findAll();
        modelMap.put("fighter",new Fighter());
        modelMap.put("users", users);
        return "add-fighter";
    }

    @PostMapping("/add-fighter")
    public String createFighter(Fighter fighter){

        fighterService.save(fighter);

        return "redirect:/fighters";
    }

    @GetMapping("/fighters/{fighterId}")
    public String getOneFighter(ModelMap modelMap, @PathVariable Long fighterId){
        Fighter fighter = fighterService.findById(fighterId);

        modelMap.put("fighter",fighter);

        return "fighter";
    }

    @PostMapping("/update-fighter")
    public String updateOneFighter(Fighter fighter){
        fighterService.save(fighter);
        return "redirect:/fighters/" + fighter.getId();
    }


    @PostMapping("/fighters/{fighterId}/delete")
    public String deleteOneFighter(@PathVariable Long fighterId){
        fighterService.delete(fighterId);
        return "redirect:/fighters";
    }



}
