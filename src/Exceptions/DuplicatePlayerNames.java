package Exceptions;

public class DuplicatePlayerNames extends RuntimeException {
    public DuplicatePlayerNames() {
        super("Players can't have duplicate names");
    }
}
