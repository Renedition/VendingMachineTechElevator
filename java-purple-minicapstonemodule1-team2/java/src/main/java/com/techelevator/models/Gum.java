package com.techelevator.models;

public class Gum extends Item{
    private String slot, name, type;
    private double price;

    public Gum(String slot, String name, double price) {
        super(slot, name, price, "Gum");
    }
    public static String getMessage(){
        return "Chewy, Chewy, Lots O Bubbles!"+'\n';
    }
}
