package com.company.domain;

public class DistrictContestant extends Contestant {
    private static final int BONUS_DEFENSE = 20;

    public DistrictContestant(int healthLevel){
        super(healthLevel);
    }

    @Override
    public void setDefenseLevel(int defenseLevel){
        super.setDefenseLevel(defenseLevel + BONUS_DEFENSE);
    }
}
