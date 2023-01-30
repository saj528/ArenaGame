package com.alexjoiner.arenagame.web;

import com.alexjoiner.arenagame.domain.Fight;
import com.alexjoiner.arenagame.domain.Fighter;
import com.alexjoiner.arenagame.service.FightService;
import com.alexjoiner.arenagame.service.FighterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class FightController {

    @Autowired
    FighterService fighterService;
    @Autowired
    FightService fightService;

    @GetMapping("/organize-fight")
    public String getAllFighters(ModelMap modelMap){
        List<Fighter> fighters = fighterService.findAll();
        modelMap.put("fighters",fighters);
        modelMap.put("fight",new Fight());
        return "organize-fight";
    }

    @PostMapping("/organize-fight")
    public String createNewFight(Fight fight){

        fightService.processFight(fight);
        fightService.save(fight);

        return "redirect:/fight/" + fight.getId();
    }

    @GetMapping("fight/{fightId}")
    public String getOneFight(ModelMap modelMap, @PathVariable Long fightId){
        Fight fight = fightService.findById(fightId);
        modelMap.put("fight",fight);
        return "fight";
    }
}
