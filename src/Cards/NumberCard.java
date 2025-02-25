package Cards;

public class NumberCard extends Card {
    private final int number;

    public NumberCard(int number, Colors color) {
        super(color);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void playAction() {}

    @Override
    public String toString() {
        return "Number Card " + getNumber();
    }
}