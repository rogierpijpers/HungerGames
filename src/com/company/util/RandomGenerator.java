package com.company.util;

import java.util.Random;

public class RandomGenerator {
    public static int getRandomNumber(int min, int max){
        if (min >= max)
            min = max - 1;

        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
