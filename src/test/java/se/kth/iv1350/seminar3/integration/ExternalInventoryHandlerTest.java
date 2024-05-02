package se.kth.iv1350.seminar3.integration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class ExternalInventoryHandlerTest {
    
    public ExternalInventoryHandlerTest() {
    }
    
    @BeforeEach
    public void setUp() {
        String itemID = null;
        ItemDTO result = null;
        ExternalInventoryHandler instance = null;
        String expectedDescription = null;
        String expectedName = null;
        double expectedPrice = -1;
        double expectedRateVAT = -1;
        
    }


    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the itemID is correct.
     */
    @Test
    public void testForCorrectID_GetItem() {
        String itemID = "101";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        ItemDTO result = instance.getItem(itemID);
        assertEquals(itemID, result.getID(),"ID  matches expected result.");
    }
    
    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the items name is correct.
     */
    @Test
    public void testForCorrectName_GetItem() {
        String itemID = "056";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        String expectedName = "Butter       ";
        ItemDTO result = instance.getItem(itemID);
        assertEquals(expectedName, result.getName(),"Name doesn't match the expected result.");
    }    

    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the description in the DTO matches the expected description.
     */
    @Test
    public void testForCorrectDescription_GetItem() {
        String itemID = "167";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        String expectedDescription = "Po-tay-toes! Boil 'em, mash 'em, stick 'em in a *stew*";
        ItemDTO result = instance.getItem(itemID);
        assertEquals(expectedDescription, result.getDescription(),"Description doesn't match expected result.");
    }

    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the price in the DTO matches the expected price.
     */
    @Test
    public void testForCorrectPrice_GetItem() {
        String itemID = "003";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        double expectedPrice = 30d;
        ItemDTO result = instance.getItem(itemID);
        assertEquals(expectedPrice, result.getPrice(), "price doesn't match expected result.");
    }

    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the VAT in the DTO matches the expected VAT.
     */
    @Test
    public void testForCorrectVAT_GetItem() {
        String itemID = "055";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        double expectedRateVAT = 0.12d;
        ItemDTO result = instance.getItem(itemID);
        assertEquals(expectedRateVAT, result.getVAT(), "VAT doesn't match expected result.");
    }

    /**
     * Test of getItem method, of class ExternalInventoryHandler.
     * Checks if the description in the DTO doesn't match the description of the
     * wrong item..
     */
    @Test
    public void testForIncorrectDescription_GetItem() {
        String itemID = "055";
        ExternalInventoryHandler instance = new ExternalInventoryHandler();
        String expectedDescription = "Po-tay-toes! Boil 'em, mash 'em, stick 'em in a *stew*";
        ItemDTO result = instance.getItem(itemID);
        assertFalse(expectedDescription.equals(result.getDescription()),"Result matches the description of the wrong item.");
    }
    
}
