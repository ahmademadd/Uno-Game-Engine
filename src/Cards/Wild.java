package Cards;

public class Wild extends WildCards {
    public Wild() {
        super(null);
    }

    @Override
    public void playAction() {
        try {
            setColor();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            setColor();
        }
    }

    @Override
    public String toString() {
        return "Wild";
    }
}