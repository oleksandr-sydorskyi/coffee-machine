package com.ssa.coffeeMachine;

import java.util.Scanner;

class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private int cupsMade;
    private static final int CLEANING_THRESHOLD = 10;

    public CoffeeMachine() {
        this(400, 540, 120, 9, 550);
    }

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.cupsMade = 0;
    }

    public void buy(Scanner scanner) {

        if (cupsMade >= CLEANING_THRESHOLD) {
            System.out.println("I need cleaning!");
            return;
        }

        System.out.println(
                "\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        System.out.print("> ");
        String choice = scanner.nextLine();

        if (choice.equals("back")) {
            return;
        }

        Coffee coffee = Coffee.fromChoice(choice);
        if (coffee == null) {
            System.out.println("Invalid choice");
            return;
        }

        makeCoffee(coffee);
    }

    private void makeCoffee(Coffee coffee) {

        if (water < coffee.water()) {
            System.out.println("Sorry, not enough water!\n");
            return;
        }
        if (milk < coffee.milk()) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < coffee.beans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!\n");

        water -= coffee.water();
        milk -= coffee.milk();
        beans -= coffee.beans();
        cups--;
        money += coffee.price();
        cupsMade++;
    }

    public void fill(Scanner scanner) {
        System.out.println("\nWrite how many ml of water you want to add:");
        System.out.print("> ");
        water += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk you want to add:");
        System.out.print("> ");
        milk += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans you want to add:");
        System.out.print("> ");
        beans += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many disposable cups you want to add:");
        System.out.print("> ");
        cups += Integer.parseInt(scanner.nextLine());
    }

    public void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    public void clean() {
        cupsMade = 0;
        System.out.println("I have been cleaned!");
    }

    public void printState() {
        System.out.printf("""

            The coffee machine has:
            %d ml of water
            %d ml of milk
            %d g of coffee beans
            %d disposable cups
            $%d of money
            
            """, water, milk, beans, cups, money);
    }
}
