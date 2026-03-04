package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachineApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        String action;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            System.out.print("> ");
            action = scanner.nextLine();
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
                case "remaining":
                    machine.printState();
                    break;
                case "exit":
                    break;
                default:
                    System.out.println("Unknown action");
            }
        } while (!action.equals("exit"));

    }
}
