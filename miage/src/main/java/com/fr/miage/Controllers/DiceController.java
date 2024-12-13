package com.fr.miage.Controllers;

import com.fr.miage.Dice;
import com.fr.miage.Entity.DiceRollLog;
import com.fr.miage.Repository.DiceRollLogRepository;
import com.fr.miage.Services.DiceRollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DiceController {

    //private final Dice dice;
    private final DiceRollLogRepository diceRollLogRepository;
    private final DiceRollService diceRollService;

    @Autowired
    public DiceController(DiceRollLogRepository diceRollLogRepository, DiceRollService diceRollService) {
        this.diceRollLogRepository = diceRollLogRepository;
        this.diceRollService = diceRollService;
    }

    @GetMapping("/rollDice")
    public List<Integer> rollDice() {
        return diceRollService.rollDices(1);
    }

    @GetMapping("/rollDices/{count}")
    public List<Integer> rollDices(@PathVariable int count) {
        return diceRollService.rollDices(count);
    }

    @GetMapping("/diceLogs")
    public List<DiceRollLog> diceLogs() {
        return diceRollLogRepository.findAll();
    }

}
