package Game;

import Cards.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    static final int numOfActionCards = 8;
    static final int numOfNumberCards = 9;
    private final List<Card> deck;
    private static Deck Instance;

    private Deck(){
        deck = new ArrayList<>();

        for (int i = 0; i <= numOfNumberCards; i++) {
            deck.add(CardFactory.createCard(i, Colors.RED));
            deck.add(CardFactory.createCard(i, Colors.YELLOW));
            deck.add(CardFactory.createCard(i, Colors.GREEN));
            deck.add(CardFactory.createCard(i, Colors.BLUE));
            if (i > 0) {
                deck.add(CardFactory.createCard(i, Colors.RED));
                deck.add(CardFactory.createCard(i, Colors.YELLOW));
                deck.add(CardFactory.createCard(i, Colors.GREEN));
                deck.add(CardFactory.createCard(i, Colors.BLUE));
            }
        }
        for (int i = 0; i < numOfActionCards; i++) {
            deck.add(CardFactory.createCard("DrawTwo", Colors.values()[i%4]));
            deck.add(CardFactory.createCard("Skip", Colors.values()[i%4]));
            deck.add(CardFactory.createCard("Reverse",Colors.values()[i%4]));
            if (i < 4)
                deck.add(CardFactory.createCard("Wild"));
            else
                deck.add(CardFactory.createCard("WildDrawFour"));
        }
        shuffleDeck();
    }

    public static Deck getInstance() {
        if (Instance == null)
            Instance = new Deck();
        return Instance;
    }

    public List<Card> draw(int number) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cards.add(deck.removeFirst());
        }
        return cards;
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void returnToDeck(List<Card> card) {
        deck.addAll(card);
        shuffleDeck();
    }

}
