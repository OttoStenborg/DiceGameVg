package se.iths.otto.game;

public class Main {
    static void main() throws IllegalArgumentException {
        while (true) {
            Player one = Player.createPlayer();
            IO.println("Andra spelaren");
            Player two = Player.createPlayer();
            Game.startaSpelet(one,two);
            Game.checkWinner(one, two);
            boolean spelaIgen = Game.askToPLayAgain();
            if (!spelaIgen) {
                IO.println("Tack för att du har spelat!");
                Game.turnOffGame();
            } else if (spelaIgen) {
                IO.println("Startar ett nytt spel!");
            }
        }

    }
}


