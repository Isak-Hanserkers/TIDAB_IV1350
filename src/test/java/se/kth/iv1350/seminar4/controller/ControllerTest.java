package se.kth.iv1350.seminar4.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminar4.model.AddedItemAndRunningTotalDTO;
import se.kth.iv1350.seminar4.model.CashRegister;
import se.kth.iv1350.seminar4.model.Sale;

/**
 *
 */
public class ControllerTest {

    @Test
    public void testScanNonExistantItem() throws Exception {
        String itemID = "this item doesn't exist";
        String correctString = "No item with identifier: " + itemID + ", exists.";
        int quantity = 1;
        CashRegister register = new CashRegister();
        Controller instance = new Controller(register);
        try {
            AddedItemAndRunningTotalDTO result = instance.scanItem(itemID, quantity);
            fail("Didn't encounter a OperationFailedException for a operation"
                    + "that should fail because the item identifier doesn't exist"
                    + "in the databse.");
        } catch (OperationFailedException correctExceptionType) {
            assertTrue((correctExceptionType.getMessage()).equals(correctString),
                    "The message accompanying the exception was incorrect");
        }
    }

    @Test
    public void testScanItemWithConnectionError() throws Exception {
        String itemID = "Connection Error";
        String correctString = "A connection error has occured.";
        int quantity = 1;
        CashRegister register = new CashRegister();
        Controller instance = new Controller(register);
        try {
            AddedItemAndRunningTotalDTO result = instance.scanItem(itemID, quantity);
            fail("Didn't encounter a OperationFailedException for a operation"
                    + "that should fail because the item identifier doesn't exist"
                    + "in the databse.");
        } catch (OperationFailedException correctExceptionType) {
            assertTrue((correctExceptionType.getMessage()).equals(correctString),
                    "The message accompanying the exception was incorrect");
        }
    }

    @Test
    public void testScanItemWithoutExceptions() throws Exception {
        String itemID = "003";
        int quantity = 1;
        CashRegister register = new CashRegister();
        Controller instance = new Controller(register);
        instance.startSale();

        try {
            AddedItemAndRunningTotalDTO result = instance.scanItem(itemID, quantity);
            return;
        } catch (OperationFailedException correctExceptionType) {
            fail("An exception has occured which caused this catch clause to "
                    + "activate when it shouldn't, since the itemID should match "
                    + "an item in the database.");
        }
    }

}
