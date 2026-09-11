package se.iths.otto.game;

public class Game {
    private String firstName;
    private String lastName;
    private int score;

    public Game(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;


    //Konstruktör

    }

    //Getters och addtoscore
    public void addToScore(int score) {
        this.score += score;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    public int getScore() {
        return score;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    //Metoder för att spela spelet, första metoden används först i main osv. Hörde att det är viktigt.
    public static boolean containNumber(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }


    public static Game createPlayer() {
        while (true) {
            try {
                String firstName = IO.readln("Ange förnamn för spelare:   ");
                String lastName = IO.readln("Ange efternamn för spelare:   ");
                if (firstName.isEmpty() || lastName.isEmpty()) {
                    throw new IllegalArgumentException("Du måste ange ett förnamn och förnamn!");
                }
                if (containNumber(firstName) || containNumber(lastName)) {
                    throw new IllegalArgumentException("Du får inte ha siffror i ditt namn");
                }
                return new Game(firstName, lastName);
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }
    }


    public static void startaSpelet(Game playerOne, Game playerTwo) {
        int i = 0;
        int ii = 0;
        while (i <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(playerTwo.getFirstName() + " " + score + "!");
            playerTwo.addToScore(score);
            i++;
        }
        while (ii <= 1) {
            IO.readln("Tryck på valfri knapp för att kasta tärning");
            int score = Dice.rollDice();
            IO.println(playerOne.getFirstName() + " " + score + "!");
            playerOne.addToScore(score);
            ii++;
        }
    }


    public static void checkWinner(Game playerOne, Game playerTwo) {
        if (playerOne.getScore() > playerTwo.getScore()) {
            IO.println(playerOne.getFullName() + " har vunnit!");
            IO.println(playerOne.getScore());
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            IO.println(playerTwo.getFullName() + " har vunnit!");
            IO.println(playerTwo.getScore());
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




