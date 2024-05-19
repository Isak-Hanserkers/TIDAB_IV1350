package se.kth.iv1350.seminar4.view;

import java.io.IOException;
import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.controller.OperationFailedException;
import se.kth.iv1350.seminar4.model.AddedItemAndRunningTotalDTO;

/**
 * This is a placeholder for the view with a hardcoded execution that calls on
 * the system operations in the controller.
 */
public class View {

    private final Controller contr;
    private AddedItemAndRunningTotalDTO itemAddedAndRunningTotal;

    /**
     * This is constructor for the placeholder view. it stores a controller for
     * that it will use and adds two observers to it.
     *
     * @param contr is the instance of the controller class that is used for a
     * given sale.
     */
    public View(Controller contr) {
        this.contr = contr;
        this.contr.addObservers(new TotalRevenueFileOutput());
        this.contr.addObservers(new TotalRevenueView());

    }

    /**
     * This is a hardcoded series of calls to the controller or to private
     * methods that make calls to the controller and prints that which is
     * supposed to be returned to the view according to the instructions. This
     * represents one instance of a sale being performed.
     *
     * @throws java.io.IOException
     */
    public void saleProcess() throws IOException {
        signalStartSale();
        scanAndPresentItem("Connection Error", 1);
        scanAndPresentItem("0", 1);
        scanAndPresentItem("101", 1);
        scanAndPresentItem("055", 3);
        scanAndPresentItem("Connection Error", 1);
        scanAndPresentItem("101", 1);
        scanAndPresentItem("167", 13);
        signalEndSale();
        payAndPrintReceipt(500d);

    }

    private void payAndPrintReceipt(double amount) {
        System.out.println("Customer pays: " + amount + "sek");
        contr.enterPayment(amount);
    }

    private void signalStartSale() {
        contr.startSale();
        System.out.println("New Sale Started");
    }

    private void signalEndSale() {
        contr.endSale();
        System.out.println("End sale:");
        System.out.println("Total cost (icluding VAT): " + itemAddedAndRunningTotal.getRunningTotal());
    }

    private void scanAndPresentItem(String itemID, int quantity) throws IOException {
        try {
            System.out.println("Add " + quantity + " item with item ID " + itemID);
            itemAddedAndRunningTotal = contr.scanItem(itemID, quantity);
            System.out.println("Item ID: " + itemAddedAndRunningTotal.getItemInfo().getID());
            System.out.println("Item name: " + itemAddedAndRunningTotal.getItemInfo().getName());
            System.out.println("Item cost: " + (itemAddedAndRunningTotal.getItemInfo().getPrice() * (1 + itemAddedAndRunningTotal.getItemInfo().getVAT())) + "SEK");
            System.out.println("Item VAT: " + itemAddedAndRunningTotal.getItemInfo().getVAT() * 100 + "%");
            System.out.println("Item Description: " + itemAddedAndRunningTotal.getItemInfo().getDescription());
            System.out.println("");
            System.out.println("Total Cost (Including VAT): " + itemAddedAndRunningTotal.getRunningTotal() + "SEK");
            System.out.println("Total VAT: " + itemAddedAndRunningTotal.getTotalVAT() + "SEK");
            System.out.println("");
        } catch (OperationFailedException e) {
            System.out.println(e.getMessage());
            System.out.println("");
        }

    }

}
