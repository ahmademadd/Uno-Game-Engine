package Game;

import Cards.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    static final int numOfActionCards = 8;
    static final int numOfNumberCards = 9;
    public List<Card> deck;

    public Deck(){
        deck = new ArrayList<>();

        for (int i = 0; i <= numOfNumberCards; i++) {
            deck.add(new NumberCard(i, Colors.RED));
            deck.add(new NumberCard(i, Colors.YELLOW));
            deck.add(new NumberCard(i, Colors.GREEN));
            deck.add(new NumberCard(i, Colors.BLUE));
            if (i > 0) {
                deck.add(new NumberCard(i, Colors.RED));
                deck.add(new NumberCard(i, Colors.YELLOW));
                deck.add(new NumberCard(i, Colors.GREEN));
                deck.add(new NumberCard(i, Colors.BLUE));
            }
        }
        for (int i = 0; i < numOfActionCards; i++) {
            deck.add(new DrawTwo(Colors.values()[i%4]));
            deck.add(new SkipCard(Colors.values()[i%4]));
            deck.add(new ReverseCard(Colors.values()[i%4]));
            if (i < 4)
                deck.add(new Wild());
            else
                deck.add(new WildDrawFour());
        }
        shuffleDeck();
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
