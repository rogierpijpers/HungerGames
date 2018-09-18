package com.company;

import com.company.controller.ArenaController;
import com.company.controller.ContestantController;
import com.company.domain.CareerContestant;
import com.company.domain.Contestant;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArenaController controller = new ArenaController();
        controller.run();
    }
}
