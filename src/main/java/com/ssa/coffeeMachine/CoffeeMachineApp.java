package com.ssa.coffeeMachine;

import java.util.Scanner;

public class CoffeeMachineApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CoffeeMachine machine = new CoffeeMachine();

        while (true) {
            System.out.println("Write action (buy, fill, take, clean, remaining, exit):");
            System.out.print("> ");
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
                case "remaining":
                    machine.printState();
                    break;
                case "clean":
                    machine.clean();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown action");
            }
        }
    }
}
