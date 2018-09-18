package com.company.domain;

public class BattleItem {
    private int attackLevel;

    public BattleItem(int attackLevel){
        this.attackLevel = attackLevel;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    @Override
    public String toString(){
        return "Attack: " + attackLevel;
    }
}
