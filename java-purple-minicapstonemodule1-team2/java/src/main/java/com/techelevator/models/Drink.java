package com.techelevator.models;

public class Drink extends Item{
    public Drink(String slot, String name, double price) {
        super(slot, name, price, "Drink");
    }
    public static String getMessage(){
        return "Drinky, Drinky, Slurp Slurp!"+'\n';
    }
}
