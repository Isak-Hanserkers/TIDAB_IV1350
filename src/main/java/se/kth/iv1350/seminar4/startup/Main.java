package se.kth.iv1350.seminar4.startup;

import java.io.IOException;
import se.kth.iv1350.seminar4.controller.Controller;
import se.kth.iv1350.seminar4.view.View;
import se.kth.iv1350.seminar4.model.CashRegister;

/**
 *
 * Starts the application and contains the Main method used to start the
 * application.
 */
public class Main {

    /**
     * This is the main method used to start the application. It creates a
     * CashRegister on startup, and then a controller that is used as a
     * parameter to create the view. It then calls on a method in the view with
     * a hardcoded example of a sale process.
     *
     * @param args The application does not take any parameters.
     * @throws java.io.IOException if the controller can't be created due to a
     * error when making the logger.
     */
    public static void main(String[] args) throws IOException {
        CashRegister cashRegister = new CashRegister();
        Controller contr = new Controller(cashRegister);
        View view = new View(contr);
        view.saleProcess();
        view.saleProcess();
    }

}
