package Cards;
import Game.*;

public class ReverseCard extends ActionCard {
    public ReverseCard(Colors color) {
        super(color);
    }

    @Override
    public String getName() {
        return "Reverse Card";
    }

    @Override
    public void playAction() {
        Game.reverseQueue();
    }
}
