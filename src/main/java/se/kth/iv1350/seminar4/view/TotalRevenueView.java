package se.kth.iv1350.seminar4.view;

import se.kth.iv1350.seminar4.model.RevenueObserver;

/**
 * This is the implementation of the ObserverInterface that shows the total
 * revenue on the user interface
 */
class TotalRevenueView implements RevenueObserver {

    private double totalRevenue;
    private int saleNumber;

    public TotalRevenueView(){
        saleNumber = 1;
    }

    /**
     * An override for the totalRevenue method that prints the total revenue
     * after each sale and which sale it was to system.out.
     */
    @Override
    public void totalRevenue(double totalPrice) {
        totalRevenue += totalPrice;
        System.out.println("");
        System.out.println("Total revenue after sale number " + saleNumber + ": " + totalRevenue + "SEK");
        saleNumber++;
        System.out.println("----------------------------------------------------");
    }
}
