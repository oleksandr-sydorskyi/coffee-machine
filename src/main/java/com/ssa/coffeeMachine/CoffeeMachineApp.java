package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachineApp {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            System.out.print("> ");
            String action = scanner.nextLine();

            switch (action) {
                case "buy" -> handleBuy(machine, scanner);
                case "fill" -> handleFill(machine, scanner);
                case "take" -> System.out.println("I gave you $" + machine.take());
                case "clean" -> {
                    machine.clean();
                    System.out.println("I have been cleaned!");
                }
                case "remaining" -> printState(machine);
                case "exit" -> System.exit(0);
                default -> System.out.println("Unknown action");
            }
        }
    }

    private static void handleBuy(CoffeeMachine machine, Scanner scanner) {
        System.out.println("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print("> ");
        String choice = scanner.nextLine();

        BuyResult result = machine.buy(choice);

        switch (result) {
            case SUCCESS -> { if (!choice.equals("back")) System.out.println("I have enough resources, making you a coffee!"); }
            case NOT_ENOUGH_WATER -> System.out.println("Sorry, not enough water!");
            case NOT_ENOUGH_MILK -> System.out.println("Sorry, not enough milk!");
            case NOT_ENOUGH_BEANS -> System.out.println("Sorry, not enough coffee beans!");
            case NOT_ENOUGH_CUPS -> System.out.println("Sorry, not enough disposable cups!");
            case NEEDS_CLEANING -> System.out.println("I need cleaning!");
            case INVALID_CHOICE -> System.out.println("Invalid choice");
        }
        System.out.println();
    }

    private static void handleFill(CoffeeMachine machine, Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int w = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many ml of milk you want to add:");
        int m = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many grams of coffee beans you want to add:");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Write how many disposable cups you want to add:");
        int c = Integer.parseInt(scanner.nextLine());

        machine.fill(w, m, b, c);
    }

    private static void printState(CoffeeMachine m) {
        System.out.printf("""
            The coffee machine has:
            %d ml of water
            %d ml of milk
            %d g of coffee beans
            %d disposable cups
            $%d of money
            """, m.getWater(), m.getMilk(), m.getBeans(), m.getCups(), m.getMoney());
    }
}
