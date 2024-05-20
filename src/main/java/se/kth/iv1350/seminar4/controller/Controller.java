package se.kth.iv1350.seminar4.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import se.kth.iv1350.seminar4.integration.DatabaseNotFoundException;
import se.kth.iv1350.seminar4.integration.ExternalAccountingHandler;
import se.kth.iv1350.seminar4.integration.ExternalInventoryHandler;
import se.kth.iv1350.seminar4.integration.ItemDTO;
import se.kth.iv1350.seminar4.integration.ItemNotFoundInDatabaseException;
import se.kth.iv1350.seminar4.integration.PrinterHandler;
import se.kth.iv1350.seminar4.model.AddedItemAndRunningTotalDTO;
import se.kth.iv1350.seminar4.model.CashRegister;
import se.kth.iv1350.seminar4.model.Item;
import se.kth.iv1350.seminar4.model.Receipt;
import se.kth.iv1350.seminar4.model.RevenueObserver;
import se.kth.iv1350.seminar4.model.Sale;
import se.kth.iv1350.seminar4.model.SaleDTO;
import se.kth.iv1350.seminar4.util.LogManager;

/**
 *
 * This is the only controller for the application and it handles all calls
 * between the model and other packages.
 */
public class Controller {

    private final CashRegister cashRegister;
    private final PrinterHandler printerHandler;
    private final ExternalInventoryHandler externalInventoryHandler;
    private final ExternalAccountingHandler externalAccountingHandler;
    private final LogManager logger;
    private Sale sale;
    private SaleDTO saleDTO;
    private Receipt receipt;

    private List<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Gives the controller access to classes in the integration layer on
     * construction.
     *
     * @param cashRegister is the object for the cash register.
     * @throws java.io.IOException if the LogManager can't be created.
     */
    public Controller(CashRegister cashRegister) throws IOException {
        this.cashRegister = cashRegister;
        this.logger = new LogManager();
        printerHandler = new PrinterHandler();
        externalInventoryHandler = new ExternalInventoryHandler();
        externalAccountingHandler = new ExternalAccountingHandler();

    }

    /**
     * Method for starting a new sale by creating a new sale object.
     */
    public void startSale() {
        this.sale = new Sale();
        this.sale.addObservers(revenueObservers);
    }

    /**
     * This is a method that retrieves an item from the external inventory and
     * adds a given quantity of said item to the sale before returning.
     *
     * @param itemID the ID for the item type that is being scanned.
     * @param quantity the number of a certain item that is to be added.
     * @return returns a object containing the information regarding the item
     * with a given itemID from the external inventory system.
     * @throws OperationFailedException if the database containing items
     * couldn't be reached or if no items with matching a matching identifier
     * exist, and depending on which exception happened it the new exception has
     * a different message.
     * @throws java.io.IOException
     */
    public AddedItemAndRunningTotalDTO scanItem(String itemID, int quantity) throws OperationFailedException, IOException {
        try {
            ItemDTO itemInfo = externalInventoryHandler.getItem(itemID);
            Item item = new Item(itemInfo, quantity);
            this.saleDTO = sale.addItemToSale(item);
            AddedItemAndRunningTotalDTO itemAndRunningTotal = new AddedItemAndRunningTotalDTO(itemInfo, saleDTO);

            return itemAndRunningTotal;
        } catch (DatabaseNotFoundException connectionException) {
            logger.logException(connectionException);
            throw new OperationFailedException("A connection error has occured.");
        } catch (ItemNotFoundInDatabaseException itemNotFound) {
            throw new OperationFailedException("No item with identifier: " + itemID + ", exists.");
        }

    }

    /**
     * Method for adding a SaleDTO with the present time.
     */
    public void endSale() {
        saleDTO = sale.updateSale();
    }

    /**
     * Method for entering the payment, updating external systems, the cash
     * register and the printing of a receipt.
     *
     * @param amount is the amount that was entered as a parameter in the view
     * and represents the amount that was paid.
     */
    public void enterPayment(double amount) {
        updateExternalSystems(saleDTO);
        receipt = new Receipt(amount, saleDTO);
        cashRegister.increaseAmountInRegister(receipt, amount);
        printerHandler.printReceipt(receipt);
        sale.notifyObservers();
    }

    private void updateExternalSystems(SaleDTO saleDTO) {
        externalInventoryHandler.updateInventory(saleDTO);
        externalAccountingHandler.updateAccountingSystem(saleDTO);
    }

    /**
     * Method for adding observers to the sale
     * 
     * @param observer is the a observer class object using the RevenueObserver
     * interface.
     */    
    public void addObservers(RevenueObserver observer) {
        revenueObservers.add(observer);
    }

}
