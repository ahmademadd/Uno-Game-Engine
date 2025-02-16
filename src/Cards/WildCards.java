package Cards;

public abstract class WildCards extends Card{
    protected WildCards(Colors color) {
        super(color);
    }
    public abstract void setColor();

}
