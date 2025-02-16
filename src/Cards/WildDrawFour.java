package Cards;
import Game.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class WildDrawFour extends WildCards {
    public WildDrawFour() {
        super(null);
    }

    public void setColor() {
        System.out.println("Choose a color: ");
        DisplayCards.printColorCards();
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                int chosenColor = input.nextInt();
                this.color = Colors.values()[chosenColor - 1];
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
    }

    @Override
    public void playAction() {
        Game.draw(4);
        try {
            setColor();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            setColor();
        }
    }

    @Override
    public String getName() {
        return "Draw Four";
    }

}
