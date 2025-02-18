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

        public String toString() {
            return name;
        }

        public List<Card> getCardList() {
            return cardList;
        }
    }
    public Queue<Player> playersQueue;
    private static Players Instance;

    private Players() {
        playersQueue = new LinkedList<>();
    }

    public static Players getInstance() {
        if (Instance == null) {
            Instance = new Players();
        }
        return Instance;
    }

    public void addPlayer(String name, List<Card> cardList) {
        playersQueue.add(new Player(name, cardList));
    }
}
