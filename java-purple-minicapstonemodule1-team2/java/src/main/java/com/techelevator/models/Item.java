package com.techelevator.models;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public abstract class Item {
    private String name, type, slot;
    private double price;
    private static int maxStock = 6;

    public Item(String slot, String name, double price, String type) {
        this.name=name;
        this.type=type;
        this.slot=slot;
        this.price=price;
    }

    public static int getMaxStock() {
        return maxStock;
    }



    public static Map<Item,Integer> productMap = new HashMap();

    public String getSlot() {
        return slot;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public static void getMap(String filePath){
      File products = new File(filePath);
      if(products.exists()==false){
          System.out.println("Not a File!");
      }
      try {
          Scanner scanFile = new Scanner(products);
          while(scanFile.hasNextLine()){
              List<String> itemList = Arrays.asList(scanFile.nextLine().split(","));
              if(itemList.size() == 4){
                  switch(itemList.get(3)){
                      case "Munchy":
                          Munchy munchyItem = new Munchy(itemList.get(0),itemList.get(1),Double.parseDouble(itemList.get(2)));
                          productMap.put(munchyItem, maxStock);
                          break;
                      case "Candy":
                          Candy candyItem = new Candy(itemList.get(0),itemList.get(1),Double.parseDouble(itemList.get(2)));
                          productMap.put(candyItem, maxStock);
                          break;
                      case "Gum":
                          Gum gumItem = new Gum(itemList.get(0),itemList.get(1),Double.parseDouble(itemList.get(2)));
                          productMap.put(gumItem, maxStock);
                          break;
                      case "Drink":
                          Drink drinkItem = new Drink(itemList.get(0),itemList.get(1),Double.parseDouble(itemList.get(2)));
                          productMap.put(drinkItem, maxStock);
                          break;
                  }
              } else {
                  System.out.println("Invalid info!");
              }
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
  }
}
