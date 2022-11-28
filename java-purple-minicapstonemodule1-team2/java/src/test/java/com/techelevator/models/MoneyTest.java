package com.techelevator.models;

import org.junit.Assert;
import org.junit.Test;

import static com.techelevator.models.Money.getMoney;
import static com.techelevator.models.Money.getPreviousMoney;

public class MoneyTest {
    @Test
    public void getMoneyShouldBeZero(){
        Assert.assertEquals("money should be equal to 0",0, getMoney(),0.0009);
    }
    @Test
    public void getPreviousMoneyShouldBeZero(){
        Assert.assertEquals("money should be equal to 0",0, getPreviousMoney(),0.0009);
    }
}
