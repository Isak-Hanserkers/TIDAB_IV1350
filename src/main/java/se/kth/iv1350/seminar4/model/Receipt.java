package se.kth.iv1350.seminar4.model;

/**
 *
 * This is the class used for the receipt.
 */
public class Receipt {

    private double amountPaid;
    private SaleDTO saleToPrint;
    private double change;

    /**
     *
     * This is the constructor used for the receipt class.
     *
     * @param payment this is the payment entered in the view.
     * @param saleDTO this is a DTO object for the sale.
     */
    public Receipt(double payment, SaleDTO saleDTO) {
        amountPaid = payment;
        saleToPrint = saleDTO;
        change = amountPaid - saleToPrint.getTotalPriceWithVAT();
    }

    /**
     * This is a getter for the SaleDTO.
     *
     * @return returns a SaleDTO.
     */
    public SaleDTO getSaleDTO() {
        return saleToPrint;
    }

    /**
     * This is a getter for the change owed.
     *
     * @return returns a double.
     */
    public double getChange() {
        return change;
    }

    /**
     * This is a getter for the amount that was paid.
     *
     * @return returns a double.
     */
    public double getAmountPaid() {
        return amountPaid;
    }
}
