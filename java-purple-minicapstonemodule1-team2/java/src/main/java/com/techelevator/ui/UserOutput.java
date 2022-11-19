package com.techelevator.ui;

import com.techelevator.models.Item;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.techelevator.application.VendingMachine.runAudit;
import static com.techelevator.ui.UserInput.money;
import static com.techelevator.ui.UserInput.previousMoney;


/**
 * Responsibilities: This class should handle formatting and displaying ALL
 * messages to the user
 * 
 * Dependencies: None
 */
public class UserOutput
{

    private static String[] labels = new String[] {
            "Hundred dollar bill","Fifty dollar bill",
            "Twenty dollar bill","Ten dollar bill",
            "Five dollar bill","One dollar bill",
            "Quarter","Dime","Nickel"
    };
    private static int[] cash = new int[] {
            10000,5000,
            2000,1000,
            500,100,
            25,10
            ,5
    };

    public static void displayMessage(String message)
    {
        try {
            System.out.println();
            System.out.println(message);
            System.out.println();
        }catch (Exception e){
            runAudit(e.getMessage());
        }
    }
    public static void returnToMain()
    {
        try{
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                 Returning to Home");
        System.out.println("***************************************************");
        System.out.println();
        }catch (Exception e){
        runAudit(e.getMessage());
    }
    }
    public static void displayHomeScreen() {
        try {
            System.out.println();
            System.out.println("***************************************************");
            System.out.println("                      Home");
            System.out.println("***************************************************");
            System.out.println();
        } catch (Exception e) {
            runAudit(e.getMessage());
        }
    }
    public static void displayPurchaseScreen() {
        try {
            System.out.println();
            System.out.println("***************************************************");
            System.out.println("                   Purchase");
            System.out.println("***************************************************");
            System.out.println();
        } catch (Exception e) {
            runAudit(e.getMessage());
        }
    }
    public static void displayDispense(Map.Entry<Item, Integer> map)
    {
        try {
        System.out.println(money);
        System.out.println("Dispensing...");
        System.out.println("*************");
        System.out.println("Item: " + map.getKey().getName());
        System.out.println("Price: " + map.getKey().getPrice());
        System.out.println("Money Remaining: " + money);
        switch (map.getKey().getType()) {
            case "Munchy":
                System.out.println("Munchy, Munchy, so Good!");
                System.out.println();
                break;
            case "Drink":
                System.out.println("Drinky, Drinky, Slurp Slurp!");
                System.out.println();
                break;
            case "Gum":
                System.out.println("Chewy, Chewy, Lots O Bubbles!");
                System.out.println();
                break;
            case "Candy":
                System.out.println("Sugar, Sugar, so Sweet!");
                System.out.println();
                break;
        }
        } catch (Exception e){
            runAudit(e.getMessage());
        }
    }
    public static void backToMain()
    {
        try {
            System.out.println("Returning to Main Menu");
            System.out.println();
            System.out.println(termination());
            System.out.println();
        }catch (Exception e){
            runAudit(e.getMessage());
        }
    }
    public static void moneyFeedQuestion()
    {
        try {
            System.out.println("Please Only add bills one at a time(1,5,10,20,50,100)" + '\n' + "Type any characters to Exit");
        } catch (Exception e){
            runAudit(e.getMessage());
        }
    }

    public static void displayItem(Map<Item,Integer> inputMap)
    {
        try {
            for (Map.Entry<Item, Integer> update : inputMap.entrySet()) {
                System.out.println("Slot: " + update.getKey().getSlot() + " Name: " + update.getKey().getName() + " Price: $" + update.getKey().getPrice()
                        + " Quantity: " + update.getValue() + " Type: " + update.getKey().getType());
            }
        }catch (Exception e){
            runAudit(e.getMessage());
        }
    }

    public static String termination() {
        try {
            if (money == 0.0) {
                return "";
            }
            int fund = (int) (money * 100);
            String change = "";
            System.out.println("Your Change is: ");
            for (int i = 0; i < 9; i++) {
                if (fund >= cash[i]) {
                    int amount = fund / cash[i];
                    fund %= cash[i];
                    change += (change.equals("") ? "" : (fund < 0 ? " and " : ", ")) + amount + " " + labels[i] + (amount > 1 ? "s" : "");
                }
            }
            runAudit("CHANGE GIVEN" + '\t' + '\t' + '$' + money + " $" + "0.00");

            money = 0;
            return change;
        } catch (Exception e) {
            runAudit(e.getMessage());
        }
        return null;
    }

}
