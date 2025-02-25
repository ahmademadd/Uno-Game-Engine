package CustomGame;

import Cards.*;
import Game.*;
import Players.Players;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CustomGame extends Game {
    @Override
    public void play() {
        addCustomCard();
        startGame();
        displayWinner();
    }

    // Before each play action made by the player, sortCardList is called
    @Override
    public void playerPlayAction(Players.Player player) {
        sortCardList(player);
        super.playerPlayAction(player);
    }

    //sort the player card list by grouping cards with the same color
    public void sortCardList(Players.Player player) {
        List<Colors> colorPriority = Arrays.asList(Colors.RED, Colors.GREEN, Colors.BLUE, Colors.YELLOW, null);
        player.getCardList().sort(Comparator.comparing(
            card -> colorPriority.indexOf(card.getColor()) // Sort by color index
        ));
    }

    // adds 10 wild custom card that sets all player card list to a chosen color
    public void addCustomCard() {
        List<Card> cards = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            cards.add(CardFactory.createCard("wild set color"));
        deck.addToDeck(cards);
    }
}