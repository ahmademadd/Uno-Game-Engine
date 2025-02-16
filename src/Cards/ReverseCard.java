package Cards;
import Game.*;

public class ReverseCard extends ActionCard {
    public ReverseCard(Colors color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Reverse Card";
    }

    @Override
    public void playAction() {
        Game.reverseQueue();
    }
}
