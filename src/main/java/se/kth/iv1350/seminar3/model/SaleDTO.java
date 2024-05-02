package se.kth.iv1350.seminar3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * This is a Data transfer object for the attributes of the class Sale.
 */
public class SaleDTO {
    private double totalPrice;
    private double totalPriceWithVAT;
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    private ArrayList<Item> items;
            
    /**
     * This is the constructor for the saleDTO object
     * @param itemList this is a list of all item class objects added so far.
     * @param price this is the total price of all items added so far.
     * @param priceWithVAT this is the price of all items added including VAT.
     * @param saleTime this is the current time.
     * @param dateOfSale this is the current date.
     */
    public SaleDTO(ArrayList<Item> itemList, double price, double priceWithVAT, LocalTime saleTime, LocalDate dateOfSale){
        this.totalPrice = price;
        this.totalPriceWithVAT = priceWithVAT;
        this.timeOfSale = saleTime;
        this.items = itemList;
        this.dateOfSale = dateOfSale;
    }
        
    public double getTotalPrice(){
        return this.totalPrice;
    }
    
    public double getTotalPriceWithVAT(){
        return this.totalPriceWithVAT;
    }
    
    public LocalTime getTimeOfSale(){
        return this.timeOfSale;
    }
    
    public LocalDate getDateOfSale(){
        return this.dateOfSale;
    }
    
    public ArrayList<Item> getItemList(){
        return this.items;
    }
}
