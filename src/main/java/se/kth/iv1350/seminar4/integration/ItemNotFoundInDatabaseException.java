package se.kth.iv1350.seminar4.integration;

/**
 * Exception class for when items aren't found
 */
public class ItemNotFoundInDatabaseException extends Exception {

    private final String itemID;

    /**
     * Creates an instance of the exception class with a message explaining why
     * the exception happened.
     *
     * @param itemID
     * @param exceptionMessage is a message explaining the cause of exception.
     */
    public ItemNotFoundInDatabaseException(String itemID, String exceptionMessage) {
        super(exceptionMessage);
        this.itemID = itemID;
    }

    /**
     * This is a getter for the item identifier that resulted in the exception.
     *
     * @return this method returns a string containing the item identifier.
     */
    public String getExceptionItemID() {
        return this.itemID;
    }
}
