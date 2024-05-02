package se.kth.iv1350.seminar3.startup;

import se.kth.iv1350.seminar3.controller.Controller;
import se.kth.iv1350.seminar3.view.View;
import se.kth.iv1350.seminar3.model.CashRegister;

/**
 *
 * Starts the application and contains the Main method used to start the application.
 */
public class Main {
    /**
    * This is the main method used to start the application.
    * It creates a CashRegister on startup, and then a controller that
    * is used as a parameter to create the view.
    * It then calls on a method in the view with a hardcoded example of a
    * sale process.
    * @param args The application does not take any parameters.
    */
    public static void main(String[] args){
       CashRegister cashRegister = new CashRegister();
       Controller contr = new Controller(cashRegister); 
        View view = new View(contr);
        view.saleProcess();
    }
    
}
