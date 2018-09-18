package com.company.domain;

public class CareerContestant extends Contestant {
    private static final int BONUS_ATTACK = 10;

    public CareerContestant(int healthLevel, BattleItem battleItem){
        super(healthLevel);
        this.setBattleItem(battleItem);
    }

    @Override
    public void setAttackLevel(int attackLevel){
        super.setAttackLevel(attackLevel + BONUS_ATTACK);
    }

}
