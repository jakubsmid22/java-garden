public abstract class Plant {

    private final String name;
    private double height;
    private final double maxHeight;
    private int age;
    private int waterNeeds;
    private final double growthRate;
    private boolean isAlive = true;
    private final boolean canSurviveWinter;
    private final double buyPrice;

    public Plant(String name, int age, int growthRate, int maxHeight, boolean canSurviveWinter, double buyPrice, double height) {
        this.name = name;
        this.age = age;
        this.growthRate = growthRate;
        this.maxHeight = maxHeight;
        this.canSurviveWinter = canSurviveWinter;
        this.buyPrice = buyPrice;
        this.height = height;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWaterNeeds(int waterNeeds) {
        this.waterNeeds += waterNeeds;
    }

    public boolean CanSurviveWinter() {
        return canSurviveWinter;
    }

    public String getName() {
        return name;
    }

    public double getHeight() {
        return height;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void grow(double millimeters) {
        if (!isAlive) {
            System.out.println("The plant " + this.name + " is not alive.");
            return;
        }
        if (height >= maxHeight) {
            System.out.println("The plant " + this.name + " can't grown anymore.");
            return;
        }
        double millimetresToGrow = Math.max((growthRate - waterNeeds), 0);
        this.height += millimetresToGrow;
        System.out.println("The plant " + this.name + " has grown " + millimetresToGrow + " millimeters.");
    }

    public void water(double mililitres) {
        if (!isAlive) {
            System.out.println("The plant " + this.name + " is not alive.");
            return;
        }
        waterNeeds -= (int) mililitres;
        if (waterNeeds <= -50) {
            System.out.println("The plant " + this.name + " has been drowned.");
        }
        else {
            System.out.println("The plat " + this.name + " has been watered, its current water need is " + waterNeeds + " / 100 ml.");
        }
    }

    public void kill() {
        this.isAlive = false;
        System.out.println("The plant " + this.name + " died.");
    }

    @Override
    public String toString() {
        return "\nName: " + this.name
                + "\nAlive: " + this.isAlive
                + "\nHeight: " + this.height
                + "\nAge: " + this.age
                + "\nWater needs: " + this.waterNeeds + " millimeters\n";
    }
}
