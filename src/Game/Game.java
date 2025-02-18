package Game;

import Players.*;

public abstract class Game {
    protected int initialCardDraw = 7;
    protected DiscardPile discardPile;
    protected static Players players;
    protected static Deck deck;
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

    public abstract void play();
    public abstract void checkSayUNO(Players.Player player);
}
