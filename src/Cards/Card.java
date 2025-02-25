package Cards;

public abstract class Card implements CardAction {
    protected Colors color;

    protected Card(Colors color) {
        this.color = color;
    }

    @Override
    public Colors getColor() {
        return color;
    }

    @Override
    public void setColor(Colors color) {
        this.color = color;
    }
    @Override
    public abstract String toString();
}