package com.company.domain;

public class BattleItem {
    private int attackLevel;
    private int defenseLevel;

    public BattleItem(int attackLevel, int defenseLevel){
        this.attackLevel = attackLevel;
        this.defenseLevel = defenseLevel;
    }

    public int getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(int attackLevel) {
        this.attackLevel = attackLevel;
    }

    public int getDefenseLevel() {
        return defenseLevel;
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    @Override
    public String toString(){
        return "Attack: " + attackLevel + " defense: " + defenseLevel;
    }
}
