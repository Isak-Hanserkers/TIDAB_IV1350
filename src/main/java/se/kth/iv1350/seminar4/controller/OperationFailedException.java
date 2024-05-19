package se.kth.iv1350.seminar4.controller;

/**
 * This is a generic exception class for when a operation in the controller
 * fails.
 */
public class OperationFailedException extends Exception {

    /**
     * Constructs an instance of the exception with a message explaining why it
     * happened.
     *
     * @param explanatoryMessage the detail message.
     */
    public OperationFailedException(String explanatoryMessage) {
        super(explanatoryMessage);
    }
}
