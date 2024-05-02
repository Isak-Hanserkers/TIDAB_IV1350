package se.kth.iv1350.seminar3.model;

import se.kth.iv1350.seminar3.integration.ItemDTO;

/**
 *
 * This is the class used for an item and the 
 * quantity being bought of that item.
 */
public class Item {
    private String itemID;
    private String itemName;
    private String itemDescription;
    private double itemPrice;
    private double itemVAT;
    private int itemQuantity;
    
 /**
 *
 * This is the constructor for the item class.
 * @param itemInfo is the row retrieved from the hardcoded array in
 * the ExternalInventoryHandler
 * @param quantity is the quantity of the item being purchased.
 */
    public Item(ItemDTO itemInfo, int quantity){
    itemID = itemInfo.getID();
    itemName = itemInfo.getName();
    itemPrice = itemInfo.getPrice();
    itemDescription = itemInfo.getDescription();
    itemVAT = itemInfo.getVAT();
    itemQuantity = quantity;
    }
    
    
/**
 *
 * This is a get method for itemID.
     * @return returns a string containing the itemID
 */
    public String getItemID(){
    return this.itemID;
    }
    
    
/**
 *
 * This is a get method for the quantity of a given item.
 * @return returns an integer matching the number of said item.
 */
    public int getItemQuantity(){
    return this.itemQuantity;
    }
    
    
/**
 *
 * This is a get method for the name of a given item.
 * @return returns the name as a string.
 */
    public String getItemName(){
    return this.itemName;
    }
    
/**
 *
 * This is a get method for the description of a given item.
 * @return returns the description as a string.
 */
    public String getItemDescription(){
    return this.itemDescription;
    }
    
/**
 *
 * This is a get method for the price of a given item.
 * @return returns the price as a Double.
 */
    public double getItemPrice(){
    return this.itemPrice;
    }

/**
 *
 * This is a get method for the VAT of a given item.
 * @return returns the VAT as a Double.
 */    
    public double getItemVAT(){
    return this.itemVAT;
    }

/**
 *
 * This is a method to increase the quantity of a item..
 * @param amountOfItemsAdded is the number of the item that is being added.
 */
public void increaseQuantity(int amountOfItemsAdded){
this.itemQuantity += amountOfItemsAdded;
}
    
}
