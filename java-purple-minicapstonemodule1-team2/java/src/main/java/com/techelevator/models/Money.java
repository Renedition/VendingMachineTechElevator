package com.techelevator.models;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.techelevator.application.VendingMachine.runAudit;
import static com.techelevator.ui.UserOutput.moneyFeedQuestion;

public class Money {
    public static double previousMoney = 0;
    public static double money = 0;
    public static double roundingMoney(double cash) {
        BigDecimal moneyTemp = new BigDecimal(cash).setScale(2, RoundingMode.HALF_UP);
        return moneyTemp.doubleValue();
    }
    public static void addMoney() {
        try {
            moneyFeedQuestion();
            Scanner scanner = new Scanner(System.in);
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

    public static double getPreviousMoney() {
        return previousMoney;
    }

    public static double getMoney() {
        return money;
    }
}
