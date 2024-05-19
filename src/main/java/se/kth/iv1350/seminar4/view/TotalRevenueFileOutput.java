package se.kth.iv1350.seminar4.view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import se.kth.iv1350.seminar4.model.RevenueObserver;

/**
 * This is the implementation of the ObserverInterface that writes the total
 * revenue to a file.
 */
public class TotalRevenueFileOutput implements RevenueObserver {

    private double totalRevenue;
    private PrintWriter revenueFile;
    private int saleNumber;

    /**
     * Code that allows for printing to file from listing 9.1
     */
    public TotalRevenueFileOutput() {
        saleNumber = 1;
        try {
            revenueFile = new PrintWriter(new FileWriter("Revenue_File.txt"), true);
        } catch (IOException ioeException) {
            System.out.println("CAN NOT WRITE TO REVENUE FILE.");
        }
    }

    /**
     * An override for the totalRevenue method that prints the total revenue
     * after each sale and which sale it was to the file Revenue_File.txt.
     */
    @Override
    public void totalRevenue(double totalPrice) {
        totalRevenue += totalPrice;
        revenueFile.println("Total revenue after sale number " + saleNumber + ": " + totalRevenue + "SEK");
        saleNumber++;
    }
}
