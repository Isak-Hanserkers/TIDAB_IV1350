package se.kth.iv1350.seminar4.integration;

/**
 * A class for the exception that occurs when the item database can't be
 * reached.
 */
public class DatabaseNotFoundException extends Exception {

    private final String itemID;

    /**
     * Creates a instance of the exception with a explanation of the cause.
     *
     * @param itemID this is the item identifier that resulted in a exception.
     * @param exceptionMessage is a message explaining the cause of the
     * exception.
     */
    public DatabaseNotFoundException(String itemID, String exceptionMessage) {
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
