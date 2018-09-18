package com.company.domain;

public class CareerContestant extends Contestant {
    private static final int BONUS_ATTACK = 10;

    public CareerContestant(BattleItem battleItem){
        super();
        this.setBattleItem(battleItem);
    }

    @Override
    public void setAttackLevel(int attackLevel){
        super.setAttackLevel(attackLevel + BONUS_ATTACK);
    }

}
