package Game;

import Cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscardPile {
    private Colors color;
    private final List<Card> discardPile;
    private static DiscardPile discardPileInstance;

    private DiscardPile(Card card) {
        discardPile = new ArrayList<>();
        discardPile.add(card);
        this.color = card.getColor();
    }

    public static DiscardPile getDiscardPileInstance(Card card) {
        if (discardPileInstance == null)
            discardPileInstance = new DiscardPile(card);
        return discardPileInstance;
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public Card getTopOfPile() {
        return discardPile.getLast();
    }

    public Colors getColor() {
        return color;
    }

    public void addToPile(Card card) throws RuntimeException {

        if (getTopOfPile() instanceof NumberCard pileNumberCard) {
            if (card instanceof NumberCard playerNumberedCard
                    && pileNumberCard.getColor() != playerNumberedCard.getColor()
                    && pileNumberCard.getNumber() != playerNumberedCard.getNumber())
                throw new RuntimeException("Card is invalid! try another card or draw from the deck!");
            else if (card instanceof ActionCard playerActionCard
                    && pileNumberCard.getColor() != playerActionCard.getColor())
                throw new RuntimeException("Card is invalid! try another card or draw from the deck!");
        } else if (getTopOfPile() instanceof ActionCard pileActionCard) {
            if (card instanceof NumberCard playerNumberedCard
                    && playerNumberedCard.getColor() != pileActionCard.getColor())
                throw new RuntimeException("Card is invalid! try another card or draw from the deck!");
            else if (card instanceof ActionCard playerActionCard
                    && pileActionCard.getColor() != playerActionCard.getColor()
                    && pileActionCard.getClass() != playerActionCard.getClass())
                throw new RuntimeException("Card is invalid! try another card or draw from the deck!");
        } else if (getTopOfPile() instanceof WildCards wildCards) {
            if (!(card instanceof WildCards)
                    && card.getColor() != wildCards.getColor())
                throw new RuntimeException("Card is invalid! try another card or draw from the deck!");
        }
        card.playAction();
        this.color = card.getColor();
        discardPile.add(card);
    }

    public void shufflePile() {
        Collections.shuffle(discardPile);
    }
}
