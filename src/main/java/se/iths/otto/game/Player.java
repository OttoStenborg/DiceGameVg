package se.iths.otto.game;

public class Player {
    private String firstName;
    private String lastName;
    private int score;

    public Player(String firstName, String lastName) {
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


    public static Player createPlayer() {
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
                return new Player(firstName, lastName);
            } catch (IllegalArgumentException e) {
                IO.println(e.getMessage());
            }
        }
    }
}
