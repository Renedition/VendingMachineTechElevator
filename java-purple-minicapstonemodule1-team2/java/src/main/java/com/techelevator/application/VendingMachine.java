package com.techelevator.application;

import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.techelevator.models.Item.getMap;
import static com.techelevator.models.Item.productMap;
import static com.techelevator.models.Money.addMoney;
import static com.techelevator.ui.UserInput.itemAvailable;
import static com.techelevator.ui.UserOutput.*;


public class VendingMachine {
    static File audit = new File("Audit.txt");

    public void run() {
        getMap("catering.csv");
        runAudit("Vending Machine Restocking");
        runAudit("Vending Machine On");
        while (true) {
            UserOutput.displayHomeScreen();
            String choice = UserInput.getHomeScreenOption();

            if (choice.equals("display")) {
                displayItem(productMap);
            } else if (choice.equals("purchase")) {
                while (true) {
                    displayPurchaseScreen();
                    String choice2 = UserInput.getPurchaseScreen();
                    if (choice2.equals("addMoney")) {
                        addMoney();
                    } else if (choice2.equals("select")) {
                        displayItem(productMap);
                        itemAvailable(productMap);
                    } else {
                        backToMain();
                        break;
                    }
                }
            } else if (choice.equals("exit")) {
                UserOutput.displayMessage("Thank you for purchasing");
                runAudit("Shutting Down Vending Machine");
                break;
            }
        }
    }


    public static void runAudit(String message) {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/y hh:mm:ss a"));
        try (PrintWriter dataOutput = new PrintWriter(
                // Passing true to the FileOutputStream constructor says to append
                new FileOutputStream(audit, true)
        )) {
            dataOutput.println(time +' '+ message);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
