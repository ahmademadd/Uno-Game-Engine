package Game;

import Cards.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    final int numOfActionCards = 8;
    final int numOfWildCards = 4;
    final int cardNumbers = 9;
    private List<Card> deck;
    private static final Deck Instance = new Deck();

    private Deck() {
        deck = new ArrayList<>();
        for (int i = 0; i <= cardNumbers; i++) {
            deck.add(CardFactory.createCard(i, Colors.RED));
            deck.add(CardFactory.createCard(i, Colors.YELLOW));
            deck.add(CardFactory.createCard(i, Colors.GREEN));
            deck.add(CardFactory.createCard(i, Colors.BLUE));
        }
        for (int i = 1; i <= cardNumbers; i++) {
            deck.add(CardFactory.createCard(i, Colors.RED));
            deck.add(CardFactory.createCard(i, Colors.YELLOW));
            deck.add(CardFactory.createCard(i, Colors.GREEN));
            deck.add(CardFactory.createCard(i, Colors.BLUE));
        }
        for (int i = 0; i < numOfActionCards; i++) {
            deck.add(CardFactory.createCard("Draw Two", Colors.values()[i%4]));
            deck.add(CardFactory.createCard("Skip", Colors.values()[i%4]));
            deck.add(CardFactory.createCard("Reverse",Colors.values()[i%4]));
        }
        for (int i = 0; i < numOfWildCards; i++) {
            deck.add(CardFactory.createCard("Wild"));
            deck.add(CardFactory.createCard("Wild Draw Four"));
        }
        shuffleDeck();
    }

    public static Deck getInstance() {
        return Instance;
    }

    public List<Card> draw(int number) {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            cards.add(deck.removeFirst());
        }
        return cards;
    }

    public void addToDeck(List<Card> card) {
        deck.addAll(card);
        shuffleDeck();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

}