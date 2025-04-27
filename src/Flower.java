public class Flower extends Plant {

    private double sellPrice;
    private final boolean fragrance;
    private final String color;
    private boolean isBloom = false;

    public Flower(String name, int age, int growthRate, int maxHeight, boolean canSurviveWinter, String color, boolean fragrance, double buyPrice, int height) {
        super(name, age, growthRate, maxHeight, canSurviveWinter, buyPrice, height);
        this.color = color;
        this.fragrance = fragrance;
        this.sellPrice = buyPrice * 0.80;
    }

    public double getPrice() {
        return this.sellPrice;
    }

    public void bloom() {
        this.isBloom = true;
        System.out.println("The plat " + super.getName() + " has blossomed.");
        this.sellPrice += 5;
    }

    public void unBloom() {
        this.isBloom = false;
        this.sellPrice -= 5;
    }

    @Override
    public String toString() {
        return super.toString() + "Color: " + this.color
                + "\nSell price: " + this.sellPrice + "$"
                + "\nIs fragrant: " + this.fragrance
                + "\nIs bloomed: " + this.isBloom + "\n";
    }

    @Override
    public void kill() {
        super.kill();
        this.sellPrice = 0;
    }

    @Override
    public void grow(double millimeters) {
        super.grow(millimeters);
        if (super.getHeight() >= super.getMaxHeight()) {
            this.bloom();
        }
    }

}
