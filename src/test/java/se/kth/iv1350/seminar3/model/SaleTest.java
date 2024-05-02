package se.kth.iv1350.seminar3.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.seminar3.integration.ItemDTO;
import se.kth.iv1350.seminar3.integration.ExternalInventoryHandler;

/**
 *Unit Test for Sale Class.
 */
public class SaleTest {
    
    public SaleTest() {
    }
   
    
    @BeforeEach
    public void setUp() {
        SaleDTO unexpectedResult = null;
        SaleDTO result = null;
    }
    
    @AfterEach
    public void tearDown() {
        SaleDTO unexpectedResult = null;
        SaleDTO result = null;
    }

    /**
     * Test of updateSale method, of class Sale.
     * Checks if the DTO created is different when using a method that is
     * supposed to update time and date and the creating a SaleDTO,
     * than when previously using one that only created a SaleDTO
     */
    @Test
    public void testUpdateSale() {
        Sale instance = new Sale();
        SaleDTO unexpectedResult = instance.createSaleDTO();
        SaleDTO result = instance.updateSale();
        assertFalse(unexpectedResult == result,"Neither the time nor the date has changed");
    }

    /**
     * Test of addItemToSale method, of class Sale.
     * The test checks if the Sale DTO made with the attributes of sale
     * changes as a result of using the addItemToSale method.
     */
    @Test
    public void testAddItemToSale() {
        ExternalInventoryHandler inventory = new ExternalInventoryHandler();
        ItemDTO itemInfo = inventory.getItem("101");
        Item item = new Item(itemInfo,1);
        Sale instance = new Sale();
        SaleDTO unexpectedResult = instance.createSaleDTO();
        SaleDTO result = instance.addItemToSale(item);
        assertFalse(unexpectedResult == result, "The sale DTO isn't different between when"
                + " it was called at the end of addItemToSale to when it was "
                + "called before addItemToSale");
    }
    
}
