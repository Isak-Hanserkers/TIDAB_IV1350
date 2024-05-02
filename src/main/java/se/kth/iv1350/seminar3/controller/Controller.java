package se.kth.iv1350.seminar3.controller;

import se.kth.iv1350.seminar3.integration.ExternalAccountingHandler;
import se.kth.iv1350.seminar3.integration.ExternalInventoryHandler;
import se.kth.iv1350.seminar3.integration.ItemDTO;
import se.kth.iv1350.seminar3.integration.PrinterHandler;
import se.kth.iv1350.seminar3.model.CashRegister;
import se.kth.iv1350.seminar3.model.Item;
import se.kth.iv1350.seminar3.model.Receipt;
import se.kth.iv1350.seminar3.model.Sale;
import se.kth.iv1350.seminar3.model.SaleDTO;

/**
 *
 * This is the only controller for the application and it handles all calls between the model and other packages.
 */
public class Controller {
    private CashRegister cashRegister;
    private PrinterHandler printerHandler;
    private ExternalInventoryHandler externalInventoryHandler;
    private ExternalAccountingHandler externalAccountingHandler;
    private Sale sale;
    private SaleDTO saleDTO;
    private Receipt receipt;
    
 /**
 * Gives the controller access to classes in the integration layer on construction.
 * @param cashRegister is the object for the cash register.
 */
    public Controller(CashRegister cashRegister){
        this.cashRegister = cashRegister;
        printerHandler = new PrinterHandler();
        externalInventoryHandler = new ExternalInventoryHandler();
        externalAccountingHandler = new ExternalAccountingHandler();
    }
    
/**
 * Method for starting a new sale by creating a new sale object.
 */
    public void startSale(){
        sale = new Sale();
    }
    
/**
 * This is a method that retrieves an item from the external inventory and adds
 * a given quantity of said item to the sale before returning.
     * @param itemID the ID for the item type that is being scanned.
     * @param quantity the number of a certain item that is to be added.
     * @return returns a object containing the information regarding the item
     * with a given itemID from the external inventory system.
 */    
    public ItemDTO scanItem(String itemID, int quantity){
        ItemDTO itemInfo = externalInventoryHandler.getItem(itemID);
        Item item = new Item(itemInfo, quantity);
        sale.addItemToSale(item);
        return itemInfo;
    }
    
/**
 * Method for adding a SaleDTO with the present time.
 */    
    public void endSale(){
        saleDTO = sale.updateSale();
    }
    
/**
 * Method for entering the payment, updating external systems, 
 * the cash register and the printing of a receipt.
     * @param amount is the amount that was entered as a parameter in the view
     * and represents the amount that was paid.
 */    
public void enterPayment(double amount){
    updateExternalSystems(saleDTO);
    receipt = new Receipt(amount, saleDTO);
    cashRegister.increaseAmountInRegister(receipt, amount);
    printerHandler.printReceipt(receipt);
    }

    private void updateExternalSystems(SaleDTO saleDTO){
    externalInventoryHandler.updateInventory(saleDTO);
    externalAccountingHandler.updateAccountingSystem(saleDTO);
    }
}
