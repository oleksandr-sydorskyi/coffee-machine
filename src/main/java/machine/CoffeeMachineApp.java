package machine;

import java.util.Scanner;

public class CoffeeMachineApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine machine =
                new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            String action = scanner.next();

            switch (action) {
                case "buy":

                    if (machine.needsCleaning()) {
                        System.out.println("I need cleaning!");
                        break;
                    }

                    System.out.println(
                            "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:"
                    );

                    String choice = scanner.next();

                    BuyResult result = machine.buy(choice);

                    switch (result) {
                        case SUCCESS -> {
                            if (!choice.equals("back")) {
                                System.out.println("I have enough resources, making you a coffee!");
                            }
                        }
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
                    }
                    break;

                case "fill":
                    System.out.println("Write how many ml of water you want to add:");
                    int water = scanner.nextInt();

                    System.out.println("Write how many ml of milk you want to add:");
                    int milk = scanner.nextInt();

                    System.out.println("Write how many grams of coffee beans you want to add:");
                    int beans = scanner.nextInt();

                    System.out.println("Write how many disposable cups you want to add:");
                    int cups = scanner.nextInt();

                    machine.fill(water, milk, beans, cups);
                    break;

                case "take":
                    System.out.println("I gave you $" + machine.take());
                    break;

                case "clean":
                    machine.clean();
                    break;

                case "remaining":
                    System.out.println("The coffee machine has:");
                    System.out.println(machine.getWater() + " ml of water");
                    System.out.println(machine.getMilk() + " ml of milk");
                    System.out.println(machine.getBeans() + " g of coffee beans");
                    System.out.println(machine.getCups() + " disposable cups");
                    System.out.println("$" + machine.getMoney() + " of money");
                    break;

                case "exit":
                    return;
            }
        }
    }
}
