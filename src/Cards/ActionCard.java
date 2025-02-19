package Cards;

public abstract class ActionCard extends Card {
    protected ActionCard(Colors color) {
        super(color);
    }

    public abstract void playAction();
}