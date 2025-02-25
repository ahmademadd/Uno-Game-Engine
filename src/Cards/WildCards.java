package Cards;

import Game.DisplayCards;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class WildCards extends Card {
    protected WildCards(Colors color) {
        super(color);
    }

    public Colors setColor() {
        System.out.println("Choose a color: ");
        DisplayCards.printColorCards();
        Scanner input = new Scanner(System.in);
        int chosenColor;
        while (true) {
            try {
                chosenColor = input.nextInt();
                setColor(Colors.values()[chosenColor - 1]);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Please enter a number!");
                input.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Selected number is not within the color list range!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return Colors.values()[chosenColor - 1];
    }
}
