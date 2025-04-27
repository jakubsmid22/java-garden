import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("******************************************");
        System.out.println("*        WELCOME TO GARDEN SIMULATOR     *");
        System.out.println("*        -------------------------       *");
        System.out.println("*  Where you can plant, grow, and bloom  *");
        System.out.println("******************************************\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("YOUR GARDEN NAME: ");
        Garden garden = new Garden(scanner.nextLine());
        Store store = new Store();

        System.out.println();
        for (int i = 0; i < garden.getName().length(); i++) {
            System.out.print("*");
        }
        System.out.println("\n" + garden.getName());
        for (int i = 0; i < garden.getName().length(); i++) {
            System.out.print("*");
        }
        System.out.println();

        while (true) {

            System.out.println("""
                    
                    What u want to do?\
                    
                    0 - show info about your garden\
                    
                    1 - buy plants\
                    
                    2 - sell plant\
                    
                    3 - sell fruit\
                    
                    4 - water plant\
                    
                    5 - next day
                    """
            );

            System.out.print("\nYour choice: ");

            String choice = scanner.next();

            switch (choice) {

                case "0":
                    System.out.println(garden.toString());
                    break;

                case "1":
                    store.printStoreItems();
                    System.out.print("You have " + garden.getMoney() + "$ " + "What you want to buy? 0 - " + (store.getPlantsSize() - 1) + ": ");
                    store.buyPlant(scanner.nextInt(), garden);
                    break;

                case "2":
                    if (garden.getPLantsSize() == 0) {
                        System.out.println("You don't have any plants.");
                    } else {
                        garden.printPlants();
                        System.out.print("What plant you want to sell? 0 - " + (garden.getPLantsSize() - 1) + ": ");
                        garden.sellPlant(scanner.nextInt());

                    }
                    break;

                case "3":
                    ArrayList<Tree> trees = new ArrayList<>();
                    int i = 0;
                    for (Plant plant : garden.getPlants()) {
                        if (plant instanceof Tree) {
                            System.out.println(i + " - " + plant.getName() + " - " + ((Tree) plant).getNumberOfFruits() + " (" + ((Tree) plant).getFruitPrice() + "$)");
                            i++;
                            trees.add((Tree) plant);
                        }
                    }

                    if (i == 0) {
                        System.out.println("You don't have any tree");
                        break;
                    }

                    System.out.print("What fruit you want to sell: ");
                    Tree treeToSell = trees.get(i);
                    System.out.print("How many fruit you want to sell: ");
                    int numberOfFruitsToSell = scanner.nextInt();

                    if (treeToSell.getNumberOfFruits() < numberOfFruitsToSell) {
                        System.out.println("You don't have enough fruit!");
                        return;
                    }

                    treeToSell.setNumberOfFruits(treeToSell.getNumberOfFruits() - numberOfFruitsToSell);
                    garden.addMoney(treeToSell.getFruitPrice() * numberOfFruitsToSell);

                    break;

                case "4" :
                    if (garden.getPLantsSize() == 0) {
                        System.out.println("You don't have any plants.");
                    } else {
                        garden.printPlants();
                        System.out.print("What plant you want to water? 0 - " + (garden.getPLantsSize() - 1) + ": ");
                        Plant plant = garden.getPlants().get(scanner.nextInt());
                        System.out.print("How many milliliters do you want to water " + plant.getName() + ": ");
                        double milliliters = scanner.nextDouble();
                        plant.water(milliliters);
                    }
                    break;

                case "5" :
                    garden.nextDay();
                    break;

                default:
                    System.out.println("Wrong input!");
                    break;
            }

        }


    }
}