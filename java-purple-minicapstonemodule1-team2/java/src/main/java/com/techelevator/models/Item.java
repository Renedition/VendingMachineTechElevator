package com.techelevator.models;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Item {
    private String name, type, slot;
    private double price;
    private static int maxStock = 6;

    public static int getMaxStock() {
        return maxStock;
    }

    public Item(String slot, String name, double price, String type){
        this.name=name;
        this.type=type;
        this.slot=slot;
        this.price=price;
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
              List<String> items = Arrays.asList(scanFile.nextLine().split(","));
              Item item = new Item(items.get(0),items.get(1),Double.parseDouble(items.get(2)),items.get(3));
              productMap.put(item, maxStock);
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      }
  }
}
