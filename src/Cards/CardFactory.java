package Cards;

import CustomGame.WildSetAllCardsColors;

public class CardFactory {
    private CardFactory(){}

    public static Card createCard(int number, Colors color){
        return new NumberCard(number,color);
    }

    public static Card createCard(String cardType, Colors color) {
        return switch (cardType.toLowerCase().trim()) {
            case "skip" -> new SkipCard(color);
            case "reverse" -> new ReverseCard(color);
            case "draw two" -> new DrawTwo(color);
            default -> throw new IllegalStateException("Unexpected value: " + cardType);
        };
    }

    public static Card createCard(String cardType) {
        return switch (cardType.toLowerCase().trim()) {
            case "wild" -> new Wild();
            case "wild draw four" -> new WildDrawFour();
            case "wild set color" -> new WildSetAllCardsColors();
            default -> throw new IllegalStateException("Unexpected value: " + cardType);
        };
    }
}
