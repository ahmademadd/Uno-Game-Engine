package Cards;

public abstract class Card implements CardAction {
    protected Colors color;

    protected Card(Colors color) {
        this.color = color;
    }

    public Colors getColor() {
        return color;
    }

    public abstract void playAction();
    public abstract String toString();
}