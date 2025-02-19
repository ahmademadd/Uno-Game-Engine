package Cards;

import Game.Deck;
import Players.Players;

public class WildDrawFour extends WildCards {
    public WildDrawFour() {
        super(null);
    }

    @Override
    public void playAction() {
        Players.Player player = Players.getInstance().getPlayersQueue().peek();
        player.getCardList().addAll(Deck.getInstance().draw(4));
        try {
            setColor();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            setColor();
        }
    }

    @Override
    public String toString() {
        return "Draw Four";
    }
}