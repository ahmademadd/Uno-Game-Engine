package Game;

import Cards.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiscardPile {
    private List<Card> discardPile;
    private static final DiscardPile Instance = new DiscardPile(initalCard());

    private DiscardPile(Card card) {
        discardPile = new ArrayList<>();
        discardPile.add(card);
    }

    public static DiscardPile getInstance() {
        return Instance;
    }

    private static Card initalCard() {
        Card card = Deck.getInstance().draw(1).getFirst();
        while (card instanceof WildCards) {
            Deck.getInstance().addToDeck(List.of(card));
            card = Deck.getInstance().draw(1).getFirst();
        }
        return card;
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
        discardPile.add(card);
    }

    public Card getTopOfPile() {
        return discardPile.getLast();
    }

    public List<Card> getDiscardPile() {
        return discardPile;
    }

    public void shufflePile() {
        Collections.shuffle(discardPile);
    }
}
