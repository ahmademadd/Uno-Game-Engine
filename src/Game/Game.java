package Game;

import Exceptions.*;
import Players.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class Game {
    protected Deck deck = Deck.getInstance();
    protected Players players = Players.getInstance();
    protected DiscardPile discardPile = DiscardPile.getInstance();
    protected final int initialCardDraw = 7;
    protected Players.Player winner;

    public final boolean isGameOver() {
        for (Players.Player player : players.getPlayersQueue()) {
            if (player.getCardList().isEmpty()) {
                winner = player;
                return true;
            }
        }
        return false;
    }

    public final void startGame() {
        inputPlayers();
        discardPile.getTopOfPile().playAction();
        while (!isGameOver()) {
            Players.Player player = players.getPlayersQueue().remove();
            players.getPlayersQueue().add(player);
            playerPlayAction(player);
        }
    }

    public void playerPlayAction(Players.Player player) {
        System.out.println("Choose your Card " + player.toString() + "! Enter " + (player.getCardList().size() + 1) + " to draw from the deck");
        DisplayCards.printPlayerCards(player);
        DisplayCards.printTopDiscardedCard(discardPile.getTopOfPile());
        Scanner scanner = new Scanner(System.in);
        int selectedCard;
        while (true) {
            try {
                selectedCard = scanner.nextInt();
                if (selectedCard == player.getCardList().size() + 1) {
                    player.getCardList().addAll(deck.draw(1));
                    return;
                }
                discardPile.addToPile(player.getCardList().get(selectedCard - 1));
                player.getCardList().remove(selectedCard - 1);
                if (player.getCardList().size() == 1)
                    sayUno(player);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selected number is not within the card list range!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void sayUno(Players.Player player) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);
        Future<String> future = executor.submit(scanner::nextLine);
        try {
            String input = future.get(4, TimeUnit.SECONDS);
            if ("UNO".equalsIgnoreCase(input.trim())) {
                System.out.println("✅ You said UNO in time!");
            } else
                throw new Exception("❌ You did not say UNO, you drew 2 cards!");
        } catch (TimeoutException e) {
            System.out.println("⏳ You did not say UNO in time, you drew 2 cards!");
            player.getCardList().addAll(deck.draw(2));
            future.cancel(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            player.getCardList().addAll(deck.draw(2));
        } finally {
            executor.shutdown();
        }
    }

    public void inputPlayers() {
        System.out.println("Please enter players name space separated");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        String[] name = names.split(" ");
        while (true) {
            try {
                if (name.length < 2 || name.length > 10)
                    throw new IllegalNumOfPlayers();
                Set<String> set = new HashSet<>();
                for (String player : name) {
                    if (!set.add(player)) {
                        throw new DuplicatePlayerNames();
                    }
                }
                break;
            } catch (IllegalNumOfPlayers | DuplicatePlayerNames e) {
                System.out.println(e.getMessage());
                names = scanner.nextLine();
                name = names.split(" ");
            }
        }
        for (String player : name)
            players.addPlayer(player, deck.draw(initialCardDraw));
    }

    public void displayWinner() {
        System.out.println(winner.toString() + " has won the game! 🎉");
    }

    public abstract void play();
}