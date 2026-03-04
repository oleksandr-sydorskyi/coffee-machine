package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write how many cups of coffee you will need:");
        System.out.print("> ");
        int cupsQuantity = scanner.nextInt();

        int water = cupsQuantity * 200;
        int milk = cupsQuantity * 50;
        int coffee = cupsQuantity * 15;

        System.out.println("For " + cupsQuantity + " cups of coffee you will need:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(coffee + " g of coffee beans");
    }
}

