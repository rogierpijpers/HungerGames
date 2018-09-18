package com.company.controller;

import com.company.domain.BattleItem;
import com.company.domain.CareerContestant;
import com.company.domain.Contestant;
import com.company.domain.DistrictContestant;
import com.company.util.RandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ContestantController {
    private static final int CONTESTANT_COUNT = 24;
    private static final int DEFAULT_MIN_STAT = 30;
    private static final int DEFAULT_MAX_STAT = 50;
    private static final int DEFAULT_MIN_ITEM = 10;
    private static final int DEFAULT_MAX_ITEM = 20;

    public static int getContestantCount() {
        return CONTESTANT_COUNT;
    }

    public static int getDefaultMinStat() {
        return DEFAULT_MIN_STAT;
    }

    public static int getDefaultMaxStat() {
        return DEFAULT_MAX_STAT;
    }

    public static int getDefaultMinItem() {
        return DEFAULT_MIN_ITEM;
    }

    public static int getDefaultMaxItem() {
        return DEFAULT_MAX_ITEM;
    }

    public static int getDefaultHealth() {
        return DEFAULT_HEALTH;
    }

    private static final int DEFAULT_HEALTH = 100;

    public List<Contestant> createContestants(){
        List<Contestant> contestants = new ArrayList<>();

        for(int i = 0; i < CONTESTANT_COUNT; i++){
            Contestant contestant;

            // one quarter of contestants is career
            if(i < (CONTESTANT_COUNT / 4))
                contestant = createCareerContestant();
            else
                contestant = createDistrictContestant();

            contestants.add(contestant);
        }

        return contestants;
    }

    private BattleItem createBattleItem(){
        int attackLevel = RandomGenerator.getRandomNumber(DEFAULT_MIN_ITEM, DEFAULT_MAX_ITEM);
        BattleItem battleItem = new BattleItem(attackLevel);
        return battleItem;
    }

    private Contestant createDistrictContestant(){
        Contestant contestant = new DistrictContestant(DEFAULT_HEALTH);
        fillRandomStats(contestant);
        return contestant;
    }

    private Contestant createCareerContestant(){
        BattleItem battleItem = createBattleItem();
        Contestant contestant = new CareerContestant(DEFAULT_HEALTH, battleItem);
        fillRandomStats(contestant);
        return contestant;
    }

    private void fillRandomStats(Contestant contestant){
        int attack = RandomGenerator.getRandomNumber(DEFAULT_MIN_STAT, DEFAULT_MAX_STAT);
        int defense = RandomGenerator.getRandomNumber(DEFAULT_MIN_STAT, DEFAULT_MAX_STAT);

        contestant.setAttackLevel(attack);
        contestant.setDefenseLevel(defense);
    }
}
