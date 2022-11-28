package com.techelevator.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.techelevator.models.Munchy.getMessage;

public class MunchyTest {
    private Munchy munchy;
    @Before
    public void setup(){
        munchy = new Munchy("A4","Chippos",3.85);
    }
    @Test
    public void getMessageShouldSayChewy(){
        Assert.assertEquals("Should say \"Munchy, Munchy, so Good!\"","Munchy, Munchy, so Good!"+'\n',getMessage());
    }
}