import java.util.ArrayList;
import java.util.stream.Collectors;

public class Garden {

    private final ArrayList<Plant> plants = new ArrayList<>();
    private int day = 0;
    private DaysTypes dayWeather;
    private final Seasonstypes seasson;
    private double money = 20;
    private final String name;
    private int years = 0;

    public Garden(String name) {
        this.name = name;
        dayWeather = DaysTypes.SUNNY;
        seasson = Seasonstypes.SPRING;
    }

    public String getName() {
        return name;
    }

    public void printPlants() {
        int index = 0;
        for (Plant plant : this.plants) {
            if (plant instanceof Tree) {
                System.out.println(index + " - " + plant.getName() + " (" + ((Tree) plant).getWoodPrice() + ")");
            } else {
                System.out.println(index + " - " + plant.getName() + " (" + ((Flower) plant).getPrice() + ")");
            }
        }

    }

    public int getPLantsSize() {
        return this.plants.size();
    }

    public void sellPlant(int index) {
        try {
            Plant plant = plants.get(index);
            plants.remove(plant);
            double price;
            if (plant instanceof Tree) {
                price = ((Tree) plant).getWoodPrice();
            }
            else {
                price = ((Flower) plant).getPrice();
            }
            this.money += price;
            System.out.println("You have sold " + plant.getName() + " for " + price + "$");
        } catch (Exception e) {
            System.out.println("You don't have this plant.");
        }
    }

    public double getMoney() {
        return money;
    }

    public void addMoney(double money) {
        this.money += money;
    }

    public void deductMoney(double money) {
        this.money -= money;
    }

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void nextDay() {
        this.day++;

        boolean newYear = false;

        if (day == 365) {
            day = 0;
            years++;
            newYear = true;
        }

        int random = (int) (Math.random() * 101);

        if (random <= 1) {
            this.dayWeather = DaysTypes.TORNADO;
        } else if (random <= 10) {
            this.dayWeather = DaysTypes.CLOUDY;
        } else if (random <= 25) {
            this.dayWeather = DaysTypes.STORM;
        } else if (random <= 55) {
            this.dayWeather = DaysTypes.RAINY;
        } else {
            this.dayWeather = DaysTypes.SUNNY;
        }

        this.showDayInfo();
        for (Plant plant : plants) {
            if(newYear) plant.setAge(plant.getAge() + 1);
            if (!plant.CanSurviveWinter() & seasson.equals(Seasonstypes.WINTER)) {
                System.out.println("The plant " + plant.getName() + " has not survived winter.");
                plant.kill();
                return;
            }
            if (plant instanceof Tree & this.dayWeather.equals(DaysTypes.SUNNY)) {
                ((Tree) plant).setNumberOfFruits(((Tree) plant).getNumberOfFruits() + 2);
            }
            if (plant instanceof Flower & this.dayWeather.equals(DaysTypes.SUNNY)) {
                ((Flower) plant).bloom();
            }
            else {
                assert plant instanceof Flower;
                ((Flower) plant).unBloom();
            }
            switch (dayWeather) {
                case RAINY -> plant.grow(1);
                case STORM -> plant.grow(0);
                case SUNNY -> plant.grow(3);
                case CLOUDY -> plant.grow(2);
                case TORNADO -> plant.kill();
            }
            plant.setWaterNeeds(10);
        }
    }

    public void showDayInfo() {
        System.out.println("Today is the day " + day + ". It's " + this.seasson + ", the weather is " + dayWeather);
    }

    public void addPlant(Plant plant) {
        plants.add(plant);
    }

    public void removePlant(Plant plant) {
        plants.remove(plant);
    }

    @Override
    public String toString() {
        for (Plant plant : plants) {
            System.out.println(plant.getName());
        }
        return "Name: " + this.name +
                "\nMoney: " + this.money +
                "\nYears: " + this.years +
                "\nDays: " + this.day +
                "\nSeason: " + this.seasson +
                "\nWeather: " + this.dayWeather +
                "\nPlants:\n" +
                plants.stream().map(Plant::toString).collect(Collectors.joining("\n"));

    }
}
