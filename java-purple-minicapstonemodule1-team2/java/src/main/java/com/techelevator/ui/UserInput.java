package com.techelevator.ui;

import com.techelevator.models.Item;

import java.util.*;

import static com.techelevator.application.VendingMachine.roundingMoney;
import static com.techelevator.application.VendingMachine.runAudit;
import static com.techelevator.ui.UserOutput.*;

/**
 * Responsibilities: This class should handle receiving ALL input from the User
 * 
 * Dependencies: None
 */
public class UserInput {
    private static Scanner scanner = new Scanner(System.in);
    public static double previousMoney = 0;
    public static double money = 0;
    private static int counterForDiscount = 0;

    public static String getHomeScreenOption() {
        try {
            counterForDiscount = 0;
            System.out.println("What would you like to do?");
            System.out.println();

            System.out.println("D) Display Vending Machine Items");
            System.out.println("P) Purchase");
            System.out.println("E) Exit");

            System.out.println();
            System.out.print("Please select an option: ");

            String selectedOption = scanner.nextLine();
            String option = selectedOption.trim().toUpperCase();

            switch (option) {
                case "D":
                    return "display";
                case "P":
                    return "purchase";
                case "E":
                    return "exit";
                default:
                    return "";
            }
        } catch (Exception e) {
            runAudit(e.getMessage());
        }
        return "";
    }

    public static String getPurchaseScreen() {

        System.out.println("(M) Feed Money");
        System.out.println("(S) Select Item");
        System.out.println("(F) Finish Transaction");
        System.out.println();
        money = roundingMoney(money);
        System.out.println("Current Money Provided: $" + money);
        try {
            System.out.print("Please select an option: ");
            String selectedOption = scanner.nextLine();
            String option = selectedOption.trim().toUpperCase();
            if (option.equals("M")) {
                return "addMoney";
            } else if (option.equals("S")) {
                return "select";
            } else {
                return "mainMenu";
            }
        } catch (Exception e) {
            runAudit(e.getMessage());
            scanner.nextLine();
            getPurchaseScreen();
        }
        return "";
    }

    public static void addMoney() {
        try {
            moneyFeedQuestion();
            try {
                int input = scanner.nextInt();
                System.out.println(input);
                while (input == 1.0 || (input) == 5.0
                        || (input) == 10 || (input) == 20
                        || (input) == 50 || (input) == 100) {
                    previousMoney = money;
                    money += input;
                    money = roundingMoney(money);
                    runAudit("MONEY FED:" + '\t' + '\t' + '$' + previousMoney + " $" + money);
                    System.out.println("updated money: $" + money);
                    moneyFeedQuestion();
                    input = scanner.nextInt();
                }
            } catch (NumberFormatException | InputMismatchException e) {
                System.out.println("Returning To Purchase Screen");
                scanner.nextLine();
            }
        }catch (Exception e){
            runAudit(e.getMessage());
        }
    }

    public static void itemAvailable(Map<Item, Integer> inputMap) {
        try {
            System.out.println("Select slot! Please Capitalize your first letter");
            String userInput = scanner.nextLine();
            boolean itemCheck = false;
            for (Map.Entry<Item, Integer> map : inputMap.entrySet()) {
                if (userInput.equals(map.getKey().getSlot())) {
                    itemCheck = true;
                    if (map.getValue() == 0) {
                        System.out.println("We are out of that item");
                    } else {
                        if (money >= map.getKey().getPrice()) {
                            previousMoney = money;
                            counterForDiscount++;
                            if (counterForDiscount % 2 == 0) {
                                money -= (map.getKey().getPrice() - 1.0);
                            } else {
                                money -= map.getKey().getPrice();
                            }
                            money = roundingMoney(money);
                            runAudit(map.getKey().getName() + '\t' + map.getKey().getSlot() + '\t' + '$' + previousMoney + " $" + money);
                            inputMap.put(map.getKey(), inputMap.get(map.getKey()) - 1);
                            displayDispense(map);
                        } else {
                            System.out.println("Please put in more money!");
                            System.out.println();
                        }
                    }
                }
            }
            if (itemCheck == false) {
                System.out.println("We Do Not Have That Slot!");
            }
        }catch (Exception e){
            runAudit(e.getMessage());
        }
    }
}
