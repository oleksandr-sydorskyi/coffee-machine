package com.ssa.coffeeMachine;

import java.util.Scanner;

class CoffeeMachine {

    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
    }

    public void buy(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino (or write - back - to return into the main menu): ");
        System.out.print("> ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                makeCoffee(250, 0, 16, 4);
                break;
            case "2":
                makeCoffee(350, 75, 20, 7);
                break;
            case "3":
                makeCoffee(200, 100, 12, 6);
                break;
            case "back":
                return;
            default:
                System.out.println("Invalid choice");
        }
    }

    private void makeCoffee(int waterNeeded, int milkNeeded, int beansNeeded, int price) {
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
            return;
        }
        if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
            return;
        }
        if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }
        if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!\n");

        water -= waterNeeded;
        milk -= milkNeeded;
        beans -= beansNeeded;
        cups--;
        money += price;

    }

    public void fill(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add: ");
        System.out.print("> ");
        water += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many ml of milk you want to add: ");
        System.out.print("> ");
        milk += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many grams of coffee beans you want to add: ");
        System.out.print("> ");
        beans += Integer.parseInt(scanner.nextLine());

        System.out.println("Write how many disposable cups you want to add: ");
        System.out.print("> ");
        cups += Integer.parseInt(scanner.nextLine());
    }

    public void take() {
        System.out.println("\nI gave you $" + money + "\n");
        money = 0;
    }

    public void printState() {
        System.out.println("\nThe coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }
}
