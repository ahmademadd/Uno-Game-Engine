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
        if (players.getPlayersQueue().size() == 2)
            players.getPlayersQueue().add(players.getPlayersQueue().remove());
        else {
            Stack<Players.Player> stack = new Stack<>();
            while (!players.getPlayersQueue().isEmpty())
                stack.add(players.getPlayersQueue().remove());
            while (!stack.isEmpty())
                players.getPlayersQueue().add(stack.pop());
            players.getPlayersQueue().add(players.getPlayersQueue().remove());
        }
    }
}