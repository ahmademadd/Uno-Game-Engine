package CustomGame;

import Game.*;
import Players.Players;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.*;

public class CustomGame extends Game {

    @Override
    public void play() {
        players = Players.getInstance();
        deck = Deck.getInstance();
        discardPile = DiscardPile.getInstance();

        String[] name = inputPlayers();

        for (String playerName : name) {
            players.addPlayer(playerName, deck.draw(initialCardDraw));
        }

        while (!isGameOver()) {
            Players.Player player = players.playersQueue.remove();
            players.playersQueue.add(player);
            playerPlayAction(player);
        }
        displayWinner();
    }

    public void playerPlayAction(Players.Player player) {
        System.out.println("Choose your Card " + player.toString() + "! Enter " + (player.getCardList().size() + 1) + " to draw from the deck");

        DisplayCards.printPlayerCards(player);
        DisplayCards.printTopDiscardedCard(discardPile.getTopOfPile());

        Scanner scanner = new Scanner(System.in);
        int selectedCard;
        while(true) {
            try {
                selectedCard = scanner.nextInt();
                if (selectedCard == player.getCardList().size() + 1) {
                    player.getCardList().addAll(deck.draw(1));
                    return;
                }
                discardPile.addToPile(player.getCardList().get(selectedCard - 1));
                player.getCardList().remove(selectedCard - 1);
                if (player.getCardList().size() == 1)
                    checkSayUNO(player);
                break;
            } catch (RuntimeException e) {
                if (e instanceof InputMismatchException) {
                    System.out.println("Please enter a number!");
                    scanner.next();
                }
                else if (e instanceof IndexOutOfBoundsException)
                    System.out.println("Selected number is not within the card list range!");
                else
                    System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void checkSayUNO(Players.Player player) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Scanner scanner = new Scanner(System.in);

        Future<String> future = executor.submit(() -> scanner.nextLine());

        try {
            String input = future.get(4, TimeUnit.SECONDS);
            if ("UNO".equalsIgnoreCase(input.trim())) {
                System.out.println("✅ You said UNO in time!");
            } else
                throw new Exception("❌ You did not say UNO, you drew 2 cards.");

        } catch (TimeoutException e) {
            System.out.println("⏳ You did not say UNO in time. you drew 2 cards.");
            player.getCardList().addAll(deck.draw(2));
            future.cancel(false);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            player.getCardList().addAll(deck.draw(2));
        } finally {
            executor.shutdown();
        }
    }

    public String[] inputPlayers() {
        System.out.println("Please enter players name space separated");
        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        String[] name = names.split(" ");

        while (true) {
            if (name.length < 2 || name.length > 10) {
                System.out.println("Illegal number of players! Enter no less than 2 player names and not more than 10");
                names = scanner.nextLine();
                name = names.split(" ");
            } else
                break;
        }
        return name;
    }
    public void displayWinner() {
        System.out.println(winner.toString() + " has won the game! 🎉");
    }
}
