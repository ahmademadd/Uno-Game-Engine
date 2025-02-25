package CustomGame;

import Cards.Card;
import Cards.Colors;
import Cards.WildCards;
import Players.Players;
import java.util.LinkedList;

public class WildSetAllCardsColors extends WildCards {
    public WildSetAllCardsColors() {
        super(null);
    }

    @Override
    public String toString() {
        return "Set Color";
    }

    @Override
    public void playAction() {
        Players.Player player = ((LinkedList<Players.Player>) Players.getInstance().getPlayersQueue()).getLast();
        Colors color = setColor();
        for (Card card : player.getCardList()) {
            if (!(card instanceof WildCards))
                card.setColor(color);
        }
    }
}
