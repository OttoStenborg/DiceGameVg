package se.iths.otto.game;

public class Game {


    //Metoder för spel lokik
    private static void startaSpelet(Player one, Player two) {
        int i = 0;
        int ii = 0;
        while (i <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(one.getFirstName() + " " + score + "!");
            one.addToScore(score);
            i++;
        }
        while (ii <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(two.getFirstName() + " " + score + "!");
            two.addToScore(score);
            ii++;
        }
    }


    private static void checkWinner(Player one, Player two) {
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


    private static boolean askToPLayAgain() {
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


    private static void turnOffGame() {
        System.exit(0);
    }


    //Metod för att spela
    public void spela(){
        while (true) {
            Player playerOne = Player.createPlayer();
            Player playerTwo = Player.createPlayer();
            startaSpelet(playerOne, playerTwo);
            checkWinner(playerOne, playerTwo);
            boolean spelaIgen = askToPLayAgain();
            if (!spelaIgen) {
                IO.println("Tack för att du har spelat!");
                Game.turnOffGame();
            } else if (spelaIgen) {
                IO.println("Startar ett nytt spel!");
            }
        }
    }
}




