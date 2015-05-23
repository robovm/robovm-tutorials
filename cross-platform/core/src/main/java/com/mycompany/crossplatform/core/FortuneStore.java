package com.mycompany.crossplatform.core;

import java.util.Random;

public class FortuneStore {
    private String[] fortunes = {
            "1. RoboVM is an awesome tool for porting Android apps to iOS.",
            "2. RoboVM is an awesome tool for porting Android apps to iOS.",
            "3. RoboVM is an awesome tool for porting Android apps to iOS.",
            "4. RoboVM is an awesome tool for porting Android apps to iOS.",
            "5. RoboVM is an awesome tool for porting Android apps to iOS.",
    };

    private static Random rng = new Random();

    public String getFortune() {
        return fortunes[rng.nextInt(fortunes.length)];
    }
}
