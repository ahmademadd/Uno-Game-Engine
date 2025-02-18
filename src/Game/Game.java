package Game;

import Players.*;

public abstract class Game {
    protected Players players;
    protected Deck deck;
    protected DiscardPile discardPile;
    protected int initialCardDraw = 7;
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
    public abstract void sayUno(Players.Player player);
}
