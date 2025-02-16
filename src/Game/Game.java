package Game;

import Cards.*;
import Players.*;
import java.util.*;

public abstract class Game {
    protected int initialCardDraw = 7;
    protected static Players players;
    protected static Deck deck;
    protected DiscardPile discardPile;
    protected Players.Player winner;

    public boolean isGameOver() {
        for (Players.Player player : players.playersQueue) {
            if (player.getCardList().isEmpty()) {
                winner = player;
                return true;
            }
        }
        return false;
    }

    public static void draw(int number) {
        assert players.playersQueue.peek() != null;
        List<Card> cardList = players.playersQueue.peek().getCardList();
        cardList.addAll(deck.draw(number));
    }

    public static void reverseQueue() {
        if (players.playersQueue.size() == 2)
            skipPlayer();
        Stack<Players.Player> stack = new Stack<>();
        while (!players.playersQueue.isEmpty())
            stack.add(players.playersQueue.remove());
        while (!stack.isEmpty())
            players.playersQueue.add(stack.pop());
        players.playersQueue.add(players.playersQueue.remove());
    }

    public static void skipPlayer() {
        players.playersQueue.add(players.playersQueue.remove());
    }

    public abstract void play();

}
