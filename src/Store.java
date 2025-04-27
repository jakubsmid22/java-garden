import java.util.ArrayList;

public class Store {

    ArrayList<Plant> plants = new ArrayList<>();

    public Store() {
        plants.add(new Tree("Apple Tree", 1, 20, 20000, true, true, 50.0, 8000));
        plants.add(new Tree("Pine Tree", 2, 15, 25000, true, false, 60.0, 9000));
        plants.add(new Tree("Oak Tree", 3, 12, 30000, true, false, 70.0, 10000));
        plants.add(new Tree("Cherry Tree", 1, 18, 15000, true, true, 45.0, 5000));
        plants.add(new Tree("Maple Tree", 5, 25, 35000, true, false, 80.0, 15000));
        plants.add(new Tree("Peach Tree", 2, 22, 18000, true, true, 55.0, 7000));
        plants.add(new Tree("Orange Tree", 1, 20, 16000, true, true, 65.0, 6000));
        plants.add(new Tree("Lemon Tree", 1, 20, 14000, true, true, 50.0, 4500));
        plants.add(new Tree("Coconut Tree", 4, 30, 24000, true, true, 90.0, 11000));
        plants.add(new Tree("Birch Tree", 1, 10, 15000, true, false, 30.0, 5000));
        plants.add(new Tree("Willow Tree", 1, 12, 16000, true, false, 35.0, 6000));
        plants.add(new Tree("Spruce Tree", 1, 14, 18000, true, false, 40.0, 7000));
        plants.add(new Tree("Hazel Tree", 1, 16, 13000, true, false, 25.0, 4500));
        plants.add(new Tree("Linden Tree", 2, 18, 19000, true, false, 45.0, 8000));

        plants.add(new Flower("Rose", 1, 10, 100, true, "Red", true, 30.0, 20));
        plants.add(new Flower("Tulip", 1, 12, 50, true, "Yellow", false, 25.0, 15));
        plants.add(new Flower("Lily", 1, 8, 70, true, "White", true, 40.0, 25));
        plants.add(new Flower("Sunflower", 1, 15, 200, true, "Yellow", false, 35.0, 60));
        plants.add(new Flower("Daffodil", 1, 10, 60, true, "Orange", true, 20.0, 30));
        plants.add(new Flower("Orchid", 1, 9, 50, true, "Purple", true, 50.0, 35));
        plants.add(new Flower("Tulip", 2, 8, 60, true, "Pink", false, 22.0, 18));
        plants.add(new Flower("Chrysanthemum", 1, 7, 80, true, "White", false, 28.0, 22));
        plants.add(new Flower("Violet", 1, 6, 40, true, "Blue", true, 25.0, 12));
        plants.add(new Flower("Lavender", 2, 11, 90, true, "Purple", true, 45.0, 40));
        plants.add(new Flower("Daisy", 1, 14, 80, true, "White", false, 20.0, 30));
        plants.add(new Flower("Marigold", 1, 13, 75, true, "Orange", false, 18.0, 28));
        plants.add(new Flower("Geranium", 1, 10, 65, true, "Red", false, 30.0, 25));
        plants.add(new Flower("Poppy", 1, 12, 100, true, "Red", true, 15.0, 35));
        plants.add(new Flower("Carnation", 1, 8, 50, true, "Pink", true, 27.0, 20));
        plants.add(new Flower("Dahlia", 1, 10, 120, true, "Yellow", false, 32.0, 50));
        plants.add(new Flower("Hibiscus", 2, 12, 80, true, "Red", true, 35.0, 45));
        plants.add(new Flower("Magnolia", 1, 10, 90, true, "White", true, 55.0, 38));
        plants.add(new Flower("Camellia", 1, 9, 70, true, "Pink", true, 40.0, 28));
        plants.add(new Flower("Jasmine", 2, 7, 65, true, "White", true, 48.0, 25));
        plants.add(new Flower("Dandelion", 1, 2, 40, true, "Yellow", false, 1.2, 10));
        plants.add(new Flower("Buttercup", 1, 3, 45, true, "Yellow", false, 1.5, 15));
        plants.add(new Flower("Aster", 1, 4, 50, true, "Purple", true, 2.0, 18));
        plants.add(new Flower("Bluebell", 1, 5, 60, true, "Blue", true, 3.0, 20));
        plants.add(new Flower("Crocus", 1, 1, 30, true, "Purple", false, 1.0, 8));
    }

    public void printStoreItems() {
        int i = 0;
        for (Plant plant : plants) {
            System.out.println( i + " - " + plant.getName() + " (" + plant.getBuyPrice() + "$)");
            i++;
        }
    }

    public int getPlantsSize() {
        return this.plants.size();
    }

    public void buyPlant(int index, Garden garden) {

        Plant plant = plants.get(index);

        try {
            if (garden.getMoney() - plant.getBuyPrice() < 0) {
                System.out.println("You don't have enough money!");
            } else {
                garden.addPlant(plant);
                garden.deductMoney(plant.getBuyPrice());
                System.out.println("You have bought " + plant.getName() + " for " + plant.getBuyPrice() + "$");
            }
        }
        catch (Exception e) {
            System.out.println("We don't have this plant.");
        }

    }

}
