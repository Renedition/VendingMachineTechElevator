package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.techelevator.models.Gum.getMessage;

public class GumTest {
    private Gum gum;
    @Before
    public void setup(){
        gum = new Gum("A1","U-Chews",1.65);
    }
    @Test
    public void getMessageShouldSayChewy(){
        Assert.assertEquals("Should say \"Chewy, Chewy, Lots O Bubbles!\"","Chewy, Chewy, Lots O Bubbles!"+'\n',getMessage());
    }
}
