package Cards;
import Players.Players;

import java.util.Stack;

public class ReverseCard extends ActionCard {
    public ReverseCard(Colors color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Reverse Card";
    }

    @Override
    public void playAction() {
        Players players = Players.getInstance();
        if (players.playersQueue.size() == 2)
            players.playersQueue.add(players.playersQueue.remove());
        else {
            Stack<Players.Player> stack = new Stack<>();
            while (!players.playersQueue.isEmpty())
                stack.add(players.playersQueue.remove());
            while (!stack.isEmpty())
                players.playersQueue.add(stack.pop());
        }
    }
}
