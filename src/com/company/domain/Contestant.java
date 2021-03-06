package com.company.domain;

import java.util.Random;

public abstract class Contestant {
    private static final int DEFAULT_HEALTH = 100;

    public int getPlayerId() {
        return playerId;
    }

    private int playerId;
    private int attackLevel;
    private int defenseLevel;
    private int healthLevel;
    private BattleItem battleItem;
    private boolean isAlive;

    private int defenseInBattle;

    public Contestant(int playerId){
        this.playerId = playerId;
        attackLevel = 0;
        defenseLevel = 0;
        this.healthLevel = DEFAULT_HEALTH;
        this.isAlive = true;
        this.defenseInBattle = defenseLevel;
    }

    /*
    10% chance to crit -> 5% extra damage
    20% chance to miss (fighting is hard in real life) -> 0 damage

    in battle defense decreases with each hit. Defense stat is reset after battle
    */
    public void attack(Contestant enemy){
        Random r = new Random();
        int percentage = r.nextInt(100);

        if(percentage <= 20){
            System.out.println("Miss! - Contestant " + playerId + " Dealt 0 damage to contestant " + enemy.getPlayerId());
            return;
        }

        int damage = getAttackLevel();
        if(percentage <= 30){
            damage = (int) Math.round(damage * 1.05);
            System.out.print("Crit! - ");
        }

        System.out.println("Contestant " + playerId + " Dealt " + damage + " damage to contestant " + enemy.getPlayerId());
        enemy.receiveDamage(damage);
    }

    public void receiveDamage(int attack){
        int damage = attack - defenseInBattle;
        defenseInBattle -= attack;

        if(defenseInBattle < 0)
            defenseInBattle = 0;

        healthLevel = healthLevel - (damage > 0 ? damage : 0);

        System.out.println("Contestant " + playerId + " health: " + healthLevel + " defense: " + defenseInBattle);

        if(healthLevel <= 0){
            isAlive = false;
            System.out.println("Contestant " + playerId + " died!");
        }
    }

    public void resetDefense(){
        this.defenseInBattle = defenseLevel;
    }

    public boolean hasBetterItem(BattleItem foundItem){
        if(battleItem == null)
            return false;

        int currentLevel = battleItem.getAttackLevel() > 0 ? battleItem.getAttackLevel() : battleItem.getDefenseLevel();
        int newLevel = foundItem.getAttackLevel() > 0 ? foundItem.getAttackLevel() : foundItem.getDefenseLevel();

        return currentLevel >= newLevel;
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
        return battleItem == null ? defenseLevel : defenseLevel + battleItem.getDefenseLevel();
    }

    public void setDefenseLevel(int defenseLevel) {
        this.defenseLevel = defenseLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    @Override
    public String toString(){
        return "ID: " + playerId + " Health: " + getHealthLevel() +" Attack: " + getAttackLevel() + " Defense: " + getDefenseLevel() + " Item: " + battleItem;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
