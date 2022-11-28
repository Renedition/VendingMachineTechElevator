package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.techelevator.models.Drink.getMessage;

public class DrinkTest {
    private Drink drink;
    @Before
    public void setup(){
        drink = new Drink("A2","Ginger Ayle",1.85);
    }
    @Test
    public void getMessageShouldSayChewy(){
        Assert.assertEquals("Should say \"Drinky, Drinky, Slurp Slurp!\"","Drinky, Drinky, Slurp Slurp!"+'\n',getMessage());
    }
}