package Cards;
import Game.*;

public class DrawTwo extends ActionCard {
    public DrawTwo(Colors color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Draw Two";
    }

    @Override
    public void playAction() {
        Game.draw(2);
    }
}
