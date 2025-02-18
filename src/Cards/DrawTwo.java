package Cards;
import Game.*;
import Players.Players;

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
        Players.Player player = Players.getInstance().playersQueue.peek();
        player.getCardList().addAll(Deck.getInstance().draw(2));
    }
}
