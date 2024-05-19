package se.kth.iv1350.seminar4.model;

import se.kth.iv1350.seminar4.integration.ItemDTO;

/**
 * This is an item containing the running total for a sale and the last item
 * that was added.
 */
public class AddedItemAndRunningTotalDTO {

    private double runningTotal;
    private double totalVAT;
    private ItemDTO itemInfo;

    /**
     * Constructor for the DTO
     *
     * @param itemInfo a DTO containing item info
     * @param saleDTO a a DTO containing the information about the entire sale.
     */
    public AddedItemAndRunningTotalDTO(ItemDTO itemInfo, SaleDTO saleDTO) {
        this.runningTotal = saleDTO.getTotalPriceWithVAT();
        this.totalVAT = saleDTO.getTotalPriceWithVAT() - saleDTO.getTotalPrice();
        this.itemInfo = itemInfo;
    }

    /**
     * Getter for the runningTotal.
     *
     * @return a double containing the running total.
     */
    public double getRunningTotal() {
        return this.runningTotal;
    }

    /**
     * Getter for the total VAT.
     *
     * @return a double containing the total VAT.
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    /**
     * Getter for the item info.
     *
     * @return a DTO containing item info.
     */
    public ItemDTO getItemInfo() {
        return this.itemInfo;
    }

}
