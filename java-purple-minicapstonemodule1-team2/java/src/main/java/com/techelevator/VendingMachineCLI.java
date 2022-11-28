package com.techelevator;

import com.techelevator.application.VendingMachine;

import java.io.File;

public class VendingMachineCLI 
{
    public static void main(String[] args) 
    {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.run();
    }
}
