package Players;
import Cards.Card;
import java.util.*;

public class Players {
    public static class Player {
        private final String name;
        private List<Card> cardList;

        private Player(String name, List<Card> cardList) {
            this.name = name;
            this.cardList = cardList;
        }

        @Override
        public String toString() {
            return name;
        }

        public List<Card> getCardList() {
            return cardList;
        }
    }
    private final Queue<Player> playersQueue;
    private static final Players Instance = new Players();

    private Players() {
        playersQueue = new LinkedList<>();
    }

    public static Players getInstance() {
        return Instance;
    }

    public Queue<Player> getPlayersQueue() {
        return playersQueue;
    }

    public void addPlayer(String name, List<Card> cardList) {
        playersQueue.add(new Player(name, cardList));
    }
}
