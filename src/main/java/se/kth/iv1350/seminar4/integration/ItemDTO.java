package se.kth.iv1350.seminar4.integration;

/**
 * DTO for items from the external inventory system
 */
public class ItemDTO {

    private String itemID;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private double itemVAT;

    /**
     * This is the constructor for an ItemDTO
     *
     * @param itemInfo this is a String array containing all info about a given
     * item in from the database.
     */
    public ItemDTO(String[] itemInfo) {
        itemID = itemInfo[0];
        itemName = itemInfo[1];
        itemDescription = itemInfo[2];
        itemPrice = Double.parseDouble(itemInfo[3]);
        itemVAT = Double.parseDouble(itemInfo[4]);
    }

    /**
     * A getter for itemID.
     */
    public String getID() {
        return this.itemID;
    }

    /**
     * A getter for the name of a item.
     */
    public String getName() {
        return this.itemName;
    }

    /**
     * A getter for the description of an item.
     */
    public String getDescription() {
        return this.itemDescription;
    }

    /**
     * A getter for the price of an item.
     */
    public double getPrice() {
        return this.itemPrice;
    }

    /**
     * A getter for the VAT rate for an item.
     */
    public double getVAT() {
        return this.itemVAT;
    }
}
