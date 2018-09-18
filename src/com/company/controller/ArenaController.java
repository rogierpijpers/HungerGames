package com.company.controller;

import com.company.domain.Contestant;
import com.company.util.RandomGenerator;

import java.util.List;

public class ArenaController {
    private List<Contestant> contestants;
    private ContestantController contestantController;

    public ArenaController(){
        contestantController = new ContestantController();
        contestants = contestantController.createContestants();
    }

    public void run() {
        while (enoughContestantsAlive())
            runDay();

        System.out.println("End of game. Winner: " + contestants.stream().filter(x -> x.isAlive()).findFirst().get());
    }

    private void runDay(){
        createEncounter();

        // find weapons (take if better than current)

        sleep();
    }

    private boolean enoughContestantsAlive(){
        int noAliveContestants = 0;
        for(Contestant contestant : contestants)
            if(contestant.isAlive())
                noAliveContestants++;

        return noAliveContestants > 1;
    }

    private void createEncounter(){
        Contestant fighter1 = getRandomContestant();
        Contestant fighter2 = getRandomContestant();

        while(fighter1.isAlive() && fighter2.isAlive()){
            fighter1.attack(fighter2);

            if(fighter2.isAlive())
                fighter2.attack(fighter1);
        }

        if(!fighter1.isAlive())
            contestants.remove(fighter1);
        if(!fighter2.isAlive())
            contestants.remove(fighter2);
    }

    private Contestant getRandomContestant(){
        Contestant contestant = null;

        while(contestant == null || !contestant.isAlive()){
            int index = RandomGenerator.getRandomNumber(0, contestants.size() - 1);
            contestant = contestants.get(index);
        }

        return contestant;
    }

    public void sleep(){
        int defaultHealth = ContestantController.getDefaultHealth();
        for(Contestant contestant : contestants)
            if(contestant.isAlive())
                contestant.setHealthLevel(defaultHealth);
    }
}
