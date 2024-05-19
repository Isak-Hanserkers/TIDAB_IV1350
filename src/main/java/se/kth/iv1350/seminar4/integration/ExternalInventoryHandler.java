package se.kth.iv1350.seminar4.integration;

import se.kth.iv1350.seminar4.model.Item;
import se.kth.iv1350.seminar4.model.SaleDTO;

/**
 *
 * This is a placeholder for the class that would otherwise communicate with the
 * external inventory system. When initialized it creates a hardcoded array with
 * one row containing the info for one item.
 */
public class ExternalInventoryHandler {

    private String[][] inventory;

    /**
     *
     * This is the constructor for the placeholder class It creates a hardcoded
     * array with one row containing the info for one item.
     *
     */
    public ExternalInventoryHandler() {
        inventory = new String[][]{
            {"101", "Chocolate Bar", "200g Chocolate Bar, 70% cocoa", "25", "0.25", "100"},
            {"003", "Flour        ", "1kg bag of wheatflour", "30", "0.06", "100"},
            {"056", "Butter       ", "500g pack of 100% real butter", "30", "0.12", "100"},
            {"055", "Milk         ", "1 liter carton of milk", "22", "0.12", "100"},
            {"167", "Potatoes     ", "Po-tay-toes! Boil 'em, mash 'em, stick 'em in a *stew*", "15", "0.06", "200"}
        };
    }

    /**
     *
     * This method retrieves a row from the array containing the item with a
     * matching ID to the one sent as a parameter, if none are found it returns
     * a hardcoded array that shows that the item wasn't found.
     *
     * @param itemID is the ID for a given item and is found in the first column
     * of the array.
     * @return returns a String array.
     * @throws
     * se.kth.iv1350.seminar4.integration.ItemNotFoundInDatabaseException
     * @throws se.kth.iv1350.seminar4.integration.DatabaseNotFoundException
     */
    public ItemDTO getItem(String itemID) throws ItemNotFoundInDatabaseException, DatabaseNotFoundException {
        if (itemID.equals("Connection Error")) {
            throw new DatabaseNotFoundException(itemID, "Database could not be reached!");
        }

        for (int loopIndex = 0; loopIndex < 5; loopIndex++) {
            if (itemID.equals(inventory[loopIndex][0])) {
                return new ItemDTO(inventory[loopIndex]);
            }
        }
        throw new ItemNotFoundInDatabaseException(itemID, "Item identifier: " + itemID + ", doesn't match any existing item");
    }

    /**
     *
     * This is a placeholder for the method that would update the external
     * inventory system if such a system was implemented. Instead it just says
     * which item IDs would have the quantity of their associated number reduced
     * and by how much.
     *
     * @param saleDTO is a DTO for the attributes in the sale class.
     */
    public void updateInventory(SaleDTO saleDTO) {
        for (Item itemInArrayList : saleDTO.getItemList()) {
            System.out.println("Told external inventory system to decrease inventory quantity");
            System.out.println("of item " + itemInArrayList.getItemID() + " by " + itemInArrayList.getItemQuantity() + " units.");
        }

    }
}
