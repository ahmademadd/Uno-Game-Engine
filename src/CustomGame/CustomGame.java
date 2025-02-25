package CustomGame;

import Cards.*;
import Game.*;
import java.util.ArrayList;
import java.util.List;

public class CustomGame extends Game {
    @Override
    public void play() {
        addCustomCard();
        startGame();
        displayWinner();
    }

    // adds 10 wild custom card that sets all player card list to a chosen color
    public void addCustomCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            cards.add(CardFactory.createCard("wild set color"));
        deck.addToDeck(cards);
    }
}