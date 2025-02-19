package Cards;
import Players.Players;

public class SkipCard extends ActionCard{
    public SkipCard(Colors color) {
        super(color);
    }

    @Override
    public String toString() {
        return "Skip Card";
    }

    @Override
    public void playAction() {
        Players players = Players.getInstance();
        players.getPlayersQueue().add(players.getPlayersQueue().remove());
    }
}
