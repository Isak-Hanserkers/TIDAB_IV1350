package se.kth.iv1350.seminar3.view;
import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.integration.ItemDTO;

/**
 * This is a placeholder for the view with a hardcoded execution that calls on
 * the system operations in the controller.
 */
public class View {
    private final Controller contr;
    private double totalCost;
    private double totalVAT;
    
/**
* This is constructor for the placeholder view.
* @param contr is the instance of the controller class that is used for a
* given sale.
*/    
    public View(Controller contr){
        this.contr = contr;

    }
    
/**
* This is a hardcoded series of calls to the controller or to private methods 
* that make calls to the controller and prints that which is supposed to be 
* returned to the view according to the instructions.
* This represents one instance of a sale being performed.
*/      
    public void saleProcess(){
        signalStartSale();
        scanAndPresentItem("101",1);
        scanAndPresentItem("055",3);
        scanAndPresentItem("101",1);
        scanAndPresentItem("167",13);        
        signalEndSale();
        payAndPrintReceipt(500d);
        
    }
    
    private void payAndPrintReceipt(double amount){
        System.out.println("Customer pays: " + amount  + "sek");
        contr.enterPayment(amount);
    }
    
    private void signalStartSale(){
       totalCost = 0d;
       totalVAT = 0d;
       contr.startSale();
       System.out.println("New Sale Started");
    }
    
    private void signalEndSale(){
        contr.endSale();
        System.out.println("End sale:"); 
        System.out.println("Total cost (icluding VAT): " + totalCost);
    }
    
    private void scanAndPresentItem(String itemID, int quantity){
        System.out.println("Add " + quantity + " item with item ID " + itemID);
        ItemDTO itemAdded = contr.scanItem(itemID, quantity);
        updateTotalCostAndVAT(itemAdded, quantity);
        System.out.println("Item ID: " + itemAdded.getID());
        System.out.println("Item name: " + itemAdded.getName());
        System.out.println("Item cost: " + (itemAdded.getPrice()*(1 + itemAdded.getVAT())) + "SEK");
        System.out.println("Item VAT: " + itemAdded.getVAT()*100 + "%");
        System.out.println("Item Description: " + itemAdded.getDescription());
        System.out.println("");
        System.out.println("Total Cost (Including VAT): " + totalCost  + "SEK");
        System.out.println("Total VAT: " + totalVAT  + "SEK");
        System.out.println("");
    }


/**
* This is a private method that
*/      
    private void updateTotalCostAndVAT(ItemDTO itemAdded, int quantity){
        totalCost += (itemAdded.getPrice()*(1 + itemAdded.getVAT()) * quantity);
        totalVAT += (itemAdded.getPrice()*itemAdded.getVAT()*quantity);
    }
}
