package com.company;
import java.util.Scanner;
public class CoffeeMachine {
    public static void printAmount(int water, int milk, int beans, int cups, int money) {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action;
        String buyOption;

        int water = 400;
        int milk = 540;
        int beans = 120;
        int cups = 9;
        int money = 550;

        printAmount(water, milk, beans, cups, money);

        do {

            System.out.println("Write action (buy, fill, take, remaining, exit): ");
            action = scanner.next();
            switch (action) {
                case "buy":
                    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino");
                    buyOption = scanner.next();

                    switch (buyOption) {
                        case "1": // espresso
                            if (water - 250 >=0 && beans - 16 >= 0 && cups - 1 >= 0) {
                                water -= 250;
                                beans -= 16;
                                cups--;
                                money += 4;
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else if (water - 250 < 0) {
                                System.out.println("Sorry, not enough water!");
                            } else if (beans - 16 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            }
                            break;
                        case "2": // latte
                            if (water - 350 >=0 && milk - 75 >= 0 && beans - 20 >= 0 && cups - 1 >= 0) {
                                water -= 350;
                                milk -= 75;
                                beans -= 20;
                                cups--;
                                money += 7;
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else if (water - 350 < 0) {
                                System.out.println("Sorry, not enough water!");
                            } else if (beans - 20 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            } else if (milk - 75 < 0) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            break;
                        case "3": // cappuccino
                            if (water - 200 >=0 && milk - 100 >= 0 && beans -12 >= 0 && cups - 1 >= 0) {
                                water -= 200;
                                milk -= 100;
                                beans -= 12;
                                cups--;
                                money += 6;
                                System.out.println("I have enough resources, making you a coffee!\n");
                            } else if (water - 200 < 0) {
                                System.out.println("Sorry, not enough water!");
                            } else if (beans - 12 < 0) {
                                System.out.println("Sorry, not enough coffee beans!");
                            } else if (cups - 1 < 0) {
                                System.out.println("Sorry, not enough disposable cups!");
                            } else if (milk - 100 < 0) {
                                System.out.println("Sorry, not enough milk!");
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case "fill":
                    System.out.println("Write how many ml of water do you want to add: ");
                    water += scanner.nextInt();
                    System.out.println("Write how many ml of milk do you want to add: ");
                    milk += scanner.nextInt();
                    System.out.println("Write how many grams of coffee beans do you want to add: ");
                    beans += scanner.nextInt();
                    System.out.println("Write how many disposable cups of coffee do you want to add: ");
                    cups += scanner.nextInt();
                    break;
                case "take":
                    System.out.println("I gave you $" + money);
                    money = 0;
                    break;
                case "remaining":
                    printAmount(water, milk, beans, cups, money);
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }
        } while (true);
    }
}
