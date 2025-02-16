package Cards;
import Game.Game;

public class SkipCard extends ActionCard{
    public SkipCard(Colors color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Skip Card";
    }

    @Override
    public void playAction() {
        Game.skipPlayer();
    }
}
