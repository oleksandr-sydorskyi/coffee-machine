package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many ml of water the coffee machine has:");
        System.out.print("> ");
        int availableWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        System.out.print("> ");
        int availableMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        System.out.print("> ");
        int availableBeans = scanner.nextInt();

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int neededCups = scanner.nextInt();

        int maxCupsWater = availableWater / 200;
        int maxCupsMilk = availableMilk / 50;
        int maxCupsBeans = availableBeans / 15;

        int maximumPossibleCups = Math.min(maxCupsWater, Math.min(maxCupsMilk, maxCupsBeans));

        if (neededCups == maximumPossibleCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (maximumPossibleCups > neededCups) {
            int extraCups = maximumPossibleCups - neededCups;
            System.out.println("Yes, I can make that amount of coffee (and even " + extraCups + " more than that)");
        } else {
            System.out.println("No, I can make only " + maximumPossibleCups + " cup(s) of coffee");
        }
    }
}

