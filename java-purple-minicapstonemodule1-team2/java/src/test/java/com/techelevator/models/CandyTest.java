package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.techelevator.models.Candy.getMessage;

public class CandyTest {
    private Candy candy;
    @Before
    public void setup(){
        candy = new Candy("A3","Snykkers",4.25);
    }
    @Test
    public void getMessageShouldSayChewy(){
        Assert.assertEquals("Should say \"Sugar, Sugar, so Sweet!\"","Sugar, Sugar, so Sweet!"+'\n',getMessage());
    }
}