package com.company.controller;

import com.company.domain.BattleItem;
import com.company.domain.Contestant;
import com.company.util.RandomGenerator;

import java.util.List;

public class ArenaController {
    private List<Contestant> contestants;
    private ContestantController contestantController;

    public ArenaController(){
        contestantController = new ContestantController();
        contestants = contestantController.createContestants();

        for(Contestant contestant : contestants)
            System.out.println(contestant);
    }

    public void run() {
        while (enoughContestantsAlive())
            runDay();

        System.out.println("End of game. Winner: " + contestants.stream().filter(x -> x.isAlive()).findFirst().get());
    }

    private void runDay() {
        createEncounter();

        dropItems();

        sleep();
    }

    private boolean enoughContestantsAlive(){
        int noAliveContestants = 0;
        for(Contestant contestant : contestants)
            if(contestant.isAlive())
                noAliveContestants++;

        return noAliveContestants > 1;
    }

    private void dropItems(){
        // drop three items each day
        for(int i = 0; i < 3; i++){
            BattleItem item = contestantController.createBattleItem();
            Contestant luckyFinder = getRandomContestant();

            System.out.println("Contestant " + luckyFinder.getPlayerId() + " found item " + item);

            if(!luckyFinder.hasBetterItem(item))
                luckyFinder.setBattleItem(item);
            else
                System.out.println("Contestant leaves item and keeps current: " + luckyFinder.getBattleItem());
        }
    }

    private void createEncounter(){
        Contestant fighter1 = getRandomContestant();
        Contestant fighter2 = getRandomContestant(fighter1);

        int noRounds = 0;
        while(fighter1.isAlive() && fighter2.isAlive()){
            fighter1.attack(fighter2);

            if(fighter2.isAlive())
                fighter2.attack(fighter1);

            noRounds++;
            if(noRounds > 4){
                System.out.println("No player could win, they both fled the scene");
                break;
            }
        }

        fighter1.resetDefense();
        fighter2.resetDefense();

        if(!fighter1.isAlive())
            contestants.remove(fighter1);
        if(!fighter2.isAlive())
            contestants.remove(fighter2);
    }

    private Contestant getRandomContestant(){
        if(contestants.size() == 1)
            return contestants.stream().findFirst().get();

        Contestant contestant = null;

        while(contestant == null || !contestant.isAlive()){
            int index = RandomGenerator.getRandomNumber(0, contestants.size() - 1);
            contestant = contestants.get(index);
        }

        return contestant;
    }

    private Contestant getRandomContestant(Contestant exclude) {
        while(true){
            Contestant contestant = getRandomContestant();
            if(contestant != exclude)
                return contestant;
        }
    }

    public void sleep(){
        for(Contestant contestant : contestants)
            if(contestant.isAlive())
                contestant.resetHealth();
    }
}
