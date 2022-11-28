package com.techelevator.application;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

public class VendingMachineTest {
    private VendingMachine vendingMachine;
    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
    }
    @Test
    public void testExist(){
        File tempFile = new File("Audit.txt");
        Assert.assertTrue(tempFile.exists());
        Assert.assertTrue(tempFile.isFile());
    }

}
