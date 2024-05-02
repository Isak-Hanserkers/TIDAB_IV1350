package se.kth.iv1350.seminar3.integration;

import se.kth.iv1350.seminar3.model.Item;
import se.kth.iv1350.seminar3.model.Receipt;

/**
 * This is a placeholder for  the class that would normally communicate with
 * the printer if this was a real store.
 */
public class PrinterHandler {
    
 /**
 * Method for printing a object of the class Receipt in the similar format
 * to the one shown in the task document.
     * @param receipt is an object containing all necessary information to print
     * a receipt.
 */
    public void printReceipt(Receipt receipt){
        System.out.println("");
        System.out.println("------------------ Begin receipt -------------------");
        System.out.println("Time of sale: " + receipt.getSaleDTO().getDateOfSale() + " " + receipt.getSaleDTO().getTimeOfSale());
        System.out.println("");
        for(Item item : receipt.getSaleDTO().getItemList()){
            System.out.println(item.getItemName() + "     " + item.getItemQuantity() + " x " + (item.getItemPrice()*(1+ item.getItemVAT())) + "   " + (item.getItemPrice()*(1+ item.getItemVAT())*(item.getItemQuantity()))+ " SEK");
        }
        System.out.println("Total:             " + receipt.getSaleDTO().getTotalPriceWithVAT() + " SEK");
        System.out.println("VAT:               " + (receipt.getSaleDTO().getTotalPriceWithVAT()-receipt.getSaleDTO().getTotalPrice()) + " SEK");
        System.out.println("");
        System.out.println("Cash               " + receipt.getAmountPaid() + "SEK");
        System.out.println("Change:            " + receipt.getChange() + " SEK");
        System.out.println("------------------ End receipt ---------------------");
        System.out.println("");
        System.out.println("Change to give customer: " + receipt.getChange() + " SEK");
    }
}
