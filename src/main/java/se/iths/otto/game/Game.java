package se.iths.otto.game;

public class Game {

    public static void startaSpelet(Player one, Player two) {
        int i = 0;
        int ii = 0;
        while (i <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(two.getFirstName() + " " + score + "!");
            two.addToScore(score);
            i++;
        }
        while (ii <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(one.getFirstName() + " " + score + "!");
            one.addToScore(score);
            ii++;
        }
    }


    public static void checkWinner(Player one, Player two) {
        if (one.getScore() > two.getScore()) {
            IO.println(one.getFullName() + " har vunnit!");
            IO.println(one.getScore());
        } else if (one.getScore() < two.getScore()) {
            IO.println(two.getFullName() + " har vunnit!");
            IO.println(two.getScore());
        } else {
            IO.println("oavgjort");
        }
    }


    public static boolean askToPLayAgain() {
        while (true) {
            try {
                String val = IO.readln("Vill du spela igen (ja eller nej)?   ");
                if (val.equalsIgnoreCase("ja")) {
                    return true;
                } else if (val.equalsIgnoreCase("nej")) {
                    return false;
                } else {
                    throw new IllegalArgumentException("Du behöver svara ja elle nej");
                }
            } catch (IllegalArgumentException e) {
                IO.println("Fel:   " + e.getMessage());
            }
        }
    }


    public static void turnOffGame() {
        System.exit(0);
    }
}




