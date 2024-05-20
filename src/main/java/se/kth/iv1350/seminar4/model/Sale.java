package se.kth.iv1350.seminar4.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.model.RevenueObserver;

/**
 *
 * This is the class used for the sale object
 */
public class Sale {

    private double totalPrice;
    private double totalPriceWithVAT;
    private LocalTime timeOfSale;
    private LocalDate dateOfSale;
    private ArrayList<Item> items;
    private SaleDTO saleDTO;

    private List<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * This is the constructor for the class used for the sale object.
     */
    public Sale() {
        totalPrice = 0;
        totalPriceWithVAT = 0;
        updateSaleTime();
    }

    private void updateSaleTime() {
        timeOfSale = LocalTime.now();
        dateOfSale = LocalDate.now();
    }

    /**
     *
     * This is a method for updating the time of sale and returning a saleDTO
     * once the sale is to end.
     *
     * @return This method returns a SaleDTO object.
     */
    public SaleDTO updateSale() {
        updateSaleTime();
        return createSaleDTO();
    }

    /**
     *
     * This is the method used to add items to the sale.
     *
     * @param item is an object of the class Item from the model package.
     *
     * This method calls on the method that updates the price and prive with VAT
     * for the sale and then checks if a matching item already exists in a
     * arraylist, in which case it increases the quantity of attribute of the
     * existing item. If not, it instead adds the item to the list. That is how
     * the alternative flow 3-4b is handled.
     * @return returns a DTO for the sale with the items added.
     */
    public SaleDTO addItemToSale(Item item) {
        updatePrice(item);
        if (items == null) {
            items = new ArrayList<>();
            items.add(item);
            return createSaleDTO();
        }

        for (Item itemInArrayList : items) {
            if ((itemInArrayList.getItemID()).equals(item.getItemID())) {
                itemInArrayList.increaseQuantity(item.getItemQuantity());
                return createSaleDTO();
            }
        }

        items.add(item);
        return createSaleDTO();
    }

    /**
     * This a private method that updates price for a sale and the price with
     * VAT included.
     */
    private void updatePrice(Item item) {
        totalPrice += (item.getItemPrice() * item.getItemQuantity());
        totalPriceWithVAT += (1 + item.getItemVAT()) * item.getItemPrice() * item.getItemQuantity();
    }

    /**
     * This is a package private method that returns a saleDTO created using the
     * attributes of the sale. It needed to be package private for testing of
     * the sale Class.
     */
    SaleDTO createSaleDTO() {
        saleDTO = new SaleDTO(items, totalPrice, totalPriceWithVAT, timeOfSale, dateOfSale);
        return saleDTO;
    }
   

    /**
     * This is a method that adds observers from a list of observers to the sale object.
     */    
    public void addObservers(List<RevenueObserver> observers) {
    for (RevenueObserver revenueObserver : observers) {
            revenueObservers.add(revenueObserver);
        }
}
    
    /**
     * This is a method used to notify the observers for the sale.
     */    
    public void notifyObservers() {
        for (RevenueObserver observer : revenueObservers) {
            observer.totalRevenue(totalPrice);
        }
    }
}
