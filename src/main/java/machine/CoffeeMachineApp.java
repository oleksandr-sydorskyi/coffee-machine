package machine;

import java.util.Scanner;

public class CoffeeMachineApp {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {

        CoffeeMachine machine =
                new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = SCANNER.next();

            switch (action) {
                case "buy" -> handleBuy(machine);
                case "fill" -> handleFill(machine);
                case "take" -> handleTake(machine);
                case "clean" -> handleClean(machine);
                case "remaining" -> handleRemaining(machine);
                case "exit" -> { return; }
            }
        }
    }

    private static void handleBuy(CoffeeMachine machine) {
        System.out.println(
                "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
        );

        String choice = SCANNER.next();

        if (choice.equals("back")) return;

        BuyResult result = machine.buy(choice);

        switch (result) {
            case SUCCESS ->
                    System.out.println("I have enough resources, making you a coffee!");
            case NOT_ENOUGH_WATER ->
                    System.out.println("Sorry, not enough water!");
            case NOT_ENOUGH_MILK ->
                    System.out.println("Sorry, not enough milk!");
            case NOT_ENOUGH_BEANS ->
                    System.out.println("Sorry, not enough coffee beans!");
            case NOT_ENOUGH_CUPS ->
                    System.out.println("Sorry, not enough disposable cups!");
            case NEEDS_CLEANING ->
                    System.out.println("I need cleaning!");
            case INVALID_CHOICE ->
                    System.out.println("Invalid choice!");
        }
    }

    private static void handleFill(CoffeeMachine machine) {
        System.out.println("Write how many ml of water you want to add:");
        int water = SCANNER.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        int milk = SCANNER.nextInt();

        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = SCANNER.nextInt();

        System.out.println("Write how many disposable cups you want to add:");
        int cups = SCANNER.nextInt();

        machine.fill(water, milk, beans, cups);
    }

    private static void handleTake(CoffeeMachine machine) {
        System.out.println("I gave you $" + machine.take());
    }

    private static void handleClean(CoffeeMachine machine) {
        machine.clean();
    }

    private static void handleRemaining(CoffeeMachine machine) {
        System.out.println("The coffee machine has:");
        System.out.println(machine.getWater() + " ml of water");
        System.out.println(machine.getMilk() + " ml of milk");
        System.out.println(machine.getBeans() + " g of coffee beans");
        System.out.println(machine.getCups() + " disposable cups");
        System.out.println("$" + machine.getMoney() + " of money");
    }
}
