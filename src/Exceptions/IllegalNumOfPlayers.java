package Exceptions;

public class IllegalNumOfPlayers extends RuntimeException {
    public IllegalNumOfPlayers() {
        super("Illegal number of players! Enter no less than 2 names and not more than 10");
    }
}
