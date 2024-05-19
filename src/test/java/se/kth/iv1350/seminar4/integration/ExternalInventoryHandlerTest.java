package se.kth.iv1350.seminar4.integration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This is a test for the class that handles the external inventory to see if
 * the exceptions are working as intended. For seminar 4 only the tests that are
 * relevant to the 2 exception cases specified in the task are tested.
 */
public class ExternalInventoryHandlerTest {

    @Test
    public void testGetNonExistantItem() throws Exception {
        String itemID = "0";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        try {
            ItemDTO result = instance.getItem(itemID);
        } catch (DatabaseNotFoundException wrongException) {
            fail("The wrong exception occured, instead of an"
                    + " ItemNotFoundInDatabaseException a"
                    + " DatabaseNotFoundException occured");
        } catch (ItemNotFoundInDatabaseException correctException) {
            return;
        }
        fail("The exception that should have been caught wasn't!");
    }

    @Test
    public void testForConnectionError() {
        String itemID = "Connection Error";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        try {
            ItemDTO result = instance.getItem(itemID);
        } catch (ItemNotFoundInDatabaseException wrongException) {
            fail("The exception for when a item isn't in the database occured."
                    + ", but it should have been the exception about not"
                    + " being able to connect to the database");
        } catch (DatabaseNotFoundException correctException) {
            return;
        }
        fail("The exception that should have been caught wasn't!");
    }

    @Test
    public void testGetExistingItem() throws Exception {
        try {
            String itemID = "101";

            ExternalInventoryHandler instance = new ExternalInventoryHandler();
            ItemDTO expectedResult;
            String[] correctRow = {"101", "Chocolate Bar", "200g Chocolate Bar, 70% cocoa", "25", "0.25", "100"};
            expectedResult = new ItemDTO(correctRow);
            ItemDTO result = instance.getItem(itemID);
            boolean matches;
            matches = true;
            if (!result.getID().equals(expectedResult.getID())) {
                matches = false;
            }
            if (!result.getName().equals(expectedResult.getName())) {
                matches = false;
            }
            if (!result.getDescription().equals(expectedResult.getDescription())) {
                matches = false;
            }
            if (result.getPrice() != expectedResult.getPrice()) {
                matches = false;
            }
            if (result.getVAT() != expectedResult.getVAT()) {
                matches = false;
            }
            assertTrue(matches);
        } catch (DatabaseNotFoundException | ItemNotFoundInDatabaseException unexpectedException) {
            fail("An exception occured i a case were no exception should occur!");
        }

    }

}
