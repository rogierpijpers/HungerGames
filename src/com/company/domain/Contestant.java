package com.company.domain;

import java.util.Random;

public abstract class Contestant {
    private static final int DEFAULT_HEALTH = 100;

    private int attackLevel;
    private int defenseLevel;
    private int healthLevel;
    private BattleItem battleItem;
    private boolean isAlive;

    public Contestant(){
        attackLevel = 0;
        defenseLevel = 0;
        this.healthLevel = DEFAULT_HEALTH;
    }

    /*
    10% chance to crit -> 5% extra damage
    20% chance to miss (fighting is hard in real life) -> 0 damage
    */
    public void attack(Contestant enemy){
        Random r = new Random();
        int percentage = r.nextInt(100);

        if(percentage >= 20){
            System.out.println("Miss! 0 damage");
            return;
        }

        int damage = getAttackLevel();
        if(percentage >= 30){
            damage = (int) Math.round(damage * 1.05);
            System.out.println("Crit!");
        }

        System.out.println("Dealt " + damage + " damage");
        enemy.receiveDamage(damage);
    }

    public void receiveDamage(int damage){
        healthLevel = healthLevel - damage;

        if(healthLevel <= 0)
            isAlive = false;
    }

    public void resetHealth(){
        this.healthLevel = DEFAULT_HEALTH;
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
