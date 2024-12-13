package com.fr.miage;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Dice {

    private int result;

    public Dice(){
        this.result = 0;
    }

    public int roll(){
        Random random = new Random();
        this.result = random.nextInt(6) + 1;
        return result;
    }
}
