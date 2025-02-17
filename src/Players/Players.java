package Players;
import Cards.Card;
import java.util.*;

public class Players {
    public class Player {
        private final String name;
        private final List<Card> cardList;

        private Player(String name, List<Card> cardList) {
            this.name = name;
            this.cardList = cardList;
        }

        public String toString() {
            return name;
        }

        public List<Card> getCardList() {
            return cardList;
        }
    }
    public Queue<Player> playersQueue;
    private static Players playersInstance;

    private Players() {
        playersQueue = new LinkedList<>();
    }

    public static Players getInstance() {
        if (playersInstance == null) {
            playersInstance = new Players();
        }
        return playersInstance;
    }

    public void addPlayer(String name, List<Card> cardList) {
        playersQueue.add(new Player(name, cardList));
    }
}
