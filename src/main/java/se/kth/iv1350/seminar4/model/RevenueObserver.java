package se.kth.iv1350.seminar4.model;

/**
 * A listener interface for receiving notifications about the change to the
 * total price attribute of the sale class.
 */
public interface RevenueObserver {

    /**
     * A placeholder method meant to be overwritten by the methods in
     * TotalRevenueView and RevenueToFile.
     *
     * @param saleDTO is the DTO object for the sale.
     */
    public void totalRevenue(SaleDTO saleDTO);
}
