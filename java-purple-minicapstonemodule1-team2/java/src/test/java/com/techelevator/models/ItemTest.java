package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.techelevator.models.Item.getMaxStock;

public class ItemTest {
    private Item item;
    @Before
    public void setup(){
        item = new Item("A1","U-Chews",1.65,"Gum") {};
    }
    @Test
    public void getSlotTest(){
        Assert.assertEquals("A1",item.getSlot());
    }
    @Test
    public void getNameTest(){
        Assert.assertEquals("U-Chews",item.getName());
    }    @Test
    public void getPriceTest(){
        Assert.assertEquals(1.65,item.getPrice(),0.000009);
    }    @Test
    public void getTypeTest(){
        Assert.assertEquals("Gum",item.getType());
    }
    @Test
    public void maxStock(){
        Assert.assertEquals(6, getMaxStock());
    }
}
