package se.iths.otto.game;

import java.util.random.RandomGenerator;

public class Dice {
    //Inte så mycket som händer här
    public static int rollDice() {
        return RandomGenerator.getDefault().nextInt(1, 7);
    }
}
