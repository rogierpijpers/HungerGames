package com.company.domain;

public abstract class Contestant {
    private int attackLevel;
    private int defenseLevel;
    private int healthLevel;
    private BattleItem battleItem;
    private boolean isAlive;

    public Contestant(int healthLevel){
        attackLevel = 0;
        defenseLevel = 0;
        this.healthLevel = healthLevel;
    }

    /*
        10% chance to crit -> 5% extra damage
        20% chance to miss (fighting is hard in real life) -> 0 damage
     */
    public void attack(Contestant enemy){
        //
    }

    public void receiveDamager(int damage){
        healthLevel = healthLevel - damage;

        if(healthLevel <= 0)
            isAlive = false;
    }

    public BattleItem getBattleItem() {
        return battleItem;
    }

    public void setBattleItem(BattleItem battleItem) {
        this.battleItem = battleItem;
    }

    public int getAttackLevel() {
        return battleItem == null ? attackLevel : attackLevel + battleItem.getAttackLevel();
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

    public int getHealthLevel() {
        return healthLevel;
    }

    @Override
    public String toString(){
        return "Health: " + getHealthLevel() +" Attack: " + getAttackLevel() + " Defense: " + getDefenseLevel() + " Item: " + battleItem;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
