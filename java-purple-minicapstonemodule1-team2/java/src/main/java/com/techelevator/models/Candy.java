package com.techelevator.models;

public class Candy extends Item{
    public Candy(String slot, String name, double price) {
        super(slot, name, price, "Candy");
    }
    public static String getMessage(){
        return "Sugar, Sugar, so Sweet!"+'\n';
    }
}
