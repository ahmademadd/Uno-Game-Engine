package Game;

import Cards.*;
import Players.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayCards {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK_FONT = "\u001B[30m";
    public static final String WHITE = "\u001B[107m";
    public static final int cardWidth = 12;
    public static final int cardHeight = 3;
    public static final int spaceBetweenCards = 2;

    private DisplayCards() {}

    public static String getColor(Colors color) {
        return switch (color) {
            case RED -> "\u001B[101m";
            case BLUE -> "\u001B[104m";
            case GREEN -> "\u001B[102m";
            case YELLOW -> "\u001B[103m";
        };
    }

    public static void printColorCards() {
        List<Card> cardList = new ArrayList<>();
        for(Colors colors : Colors.values()){
            Card card = new NumberCard(0,colors);
            cardList.add(card);
        }
        String colorCards = spaceParts(cardList) + spaceParts(cardList) + drawNumbers(cardList);
        System.out.println(colorCards);
    }

    private static String space(int n) {
        StringBuilder s = new StringBuilder();
        while (n-- > 0)
            s.append(" ");
        return s.toString();
    }

    public static void printPlayerCards(Players.Player player) {
        List<Card> cardList = player.getCardList();
        String playerCards = spaceParts(cardList) + namePart(cardList) + spaceParts(cardList) + drawNumbers(cardList);
        System.out.println(playerCards);
    }

    private static String spaceParts(List<Card> cardList) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < cardHeight; i++) {
            for (Card card : cardList) {
                String color;
                if(card.getClass() == Wild.class || card.getClass() == WildDrawFour.class)
                    color = card.getColor() == null ? WHITE : getColor(card.getColor());
                else
                    color = getColor(card.getColor());
                String fill = color + space(cardWidth) + RESET + space(spaceBetweenCards);
                stringBuilder.append(fill);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public static void printTopDiscardedCard(Card card) {
        System.out.println("Discard Pile");
        List<Card> cardList = new ArrayList<>();
        cardList.add(card);
        String discardPile = spaceParts(cardList) + namePart(cardList) + spaceParts(cardList);
        System.out.println(discardPile);
    }

    private static String namePart(List<Card> cardList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Card card : cardList) {
            String name = card.toString();
            String color;
            if(card.getClass() == Wild.class || card.getClass() == WildDrawFour.class)
                color = card.getColor() == null ? WHITE : getColor(card.getColor());

            else if(card.getClass() == NumberCard.class) {
                name = Integer.toString(((NumberCard) card).getNumber());
                color = getColor(card.getColor());
            }
            else
                color = getColor(card.getColor());
            int spaceCount = (cardWidth - name.length()) / 2;
            String fill = color + space(spaceCount) + BLACK_FONT + name + space(cardWidth - (name.length() + spaceCount)) + RESET + space(spaceBetweenCards);
            stringBuilder.append(fill);
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

    private static String drawNumbers(List<Card> cardList) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(space((cardWidth - 1) / 2));
        for(int i = 1; i <= cardList.size(); i++)
            stringBuilder.append(i).append(space(cardWidth + (i < 10 ? 1 : 0)));
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
