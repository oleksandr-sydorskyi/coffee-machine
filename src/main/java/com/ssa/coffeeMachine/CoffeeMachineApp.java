package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachineApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        machine.printState();

        System.out.println("Write action (buy, fill, take): ");
        String action = scanner.nextLine();

        switch (action) {
            case "buy":
                machine.buy(scanner);
                break;
            case "fill":
                machine.fill(scanner);
                break;
            case "take":
                machine.take();
                break;
            default:
                System.out.println("Unknown action");
        }

        machine.printState();
    }
}
