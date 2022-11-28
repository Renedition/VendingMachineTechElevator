package com.techelevator.models;

public class Munchy extends Item{
    public Munchy(String slot, String name, double price) {
        super(slot, name, price, "Munchy");
    }
    public static String getMessage(){
        return "Munchy, Munchy, so Good!"+'\n';
    }
}
