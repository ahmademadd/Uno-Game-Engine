package Players;
import Cards.Card;
import java.util.*;

public class Players {
    public class Player {
        private final String name;
        private List<Card> cardList;

        public Player(String name, List<Card> cardList) {
            this.name = name;
            this.cardList = cardList;
        }

        public String getName() {
            return name;
        }

        public List<Card> getCardList() {
            return cardList;
        }
    }
    public Queue<Player> playersQueue;

    public Players() {
        playersQueue = new LinkedList<>();
    }

    public void addPlayer(String name, List<Card> cardList) {
        playersQueue.add(new Player(name, cardList));
    }
}
