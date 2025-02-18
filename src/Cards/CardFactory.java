package Cards;

public class CardFactory {
    public static Card createCard(int number, Colors color){
        return new NumberCard(number,color);
    }

    public static Card createCard(String cardType, Colors color) {
        return switch (cardType) {
            case "Skip" -> new SkipCard(color);
            case "Reverse" -> new ReverseCard(color);
            case "DrawTwo" -> new DrawTwo(color);
            default -> throw new IllegalStateException("Unexpected value: " + cardType);
        };
    }

    public static Card createCard(String cardType) {
        return switch (cardType) {
            case "Wild" -> new Wild();
            case "WildDrawFour" -> new WildDrawFour();
            default -> throw new IllegalStateException("Unexpected value: " + cardType);
        };
    }
}
