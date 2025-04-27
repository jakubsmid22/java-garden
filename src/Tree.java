public class Tree extends Plant {

    private final boolean isFruitBearing;
    private double woodPrice;
    private final double fruitPrice;
    private int numberOfFruits;

    public Tree(String name, int age, int growthRate, int maxHeight, boolean canSurviveWinter, boolean isFruitBearing, double buyPrice, int height) {
        super(name, age, growthRate, maxHeight, canSurviveWinter, buyPrice, height);
        this.isFruitBearing = isFruitBearing;
        this.fruitPrice = isFruitBearing ? (double) (Math.random() * 5) : 0;
        this.woodPrice = buyPrice * 0.25;
    }

    public double getWoodPrice() {
        return this.woodPrice;
    }

    public int getNumberOfFruits() {
        return numberOfFruits;
    }

    public double getFruitPrice() {
        return fruitPrice;
    }

    @Override
    public String toString() {
        return super.toString() + "Is fruit bearing: " + this.isFruitBearing
                + "\nSell price: " + this.woodPrice + "$"
                + "\nNumber of fruits: " + this.numberOfFruits
                + "\nFruit sell price: " + this.fruitPrice + "\n";
    }


    public void setNumberOfFruits(int numberOfFruits) {
        this.numberOfFruits = numberOfFruits;
    }

    @Override
    public void kill() {
        super.kill();
        this.woodPrice = 0;
    }

    @Override
    public void grow(double millimeters) {
        super.grow(millimeters);
        if (isFruitBearing) {
            numberOfFruits += 1;
        }
    }
}
