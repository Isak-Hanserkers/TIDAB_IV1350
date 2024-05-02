package se.kth.iv1350.seminar3.model;

/**
 *
 * This is the class for the cash register.
 * An object of this class has an attribute representing
 * the amount in the register and a method that increases it.
 */
public class CashRegister {
    private double amountInRegister;
    
    
/**
 * This is the constructor for the cash register.
 * the register starts with an initial amount of money stored in it.
 */    
    public CashRegister(){
    amountInRegister = 1234.56d;
    }
    
 /**
 * This is a package level method for updating the amount in the register by
 * the amount that was paid minus the amount of change that was returned.
     * @param receipt is a object of the type receipt.
     * @param amount is the amount entered in the view, representing the amount
     * that was paid.
 */   
    public void increaseAmountInRegister(Receipt receipt, double amount){
        amountInRegister += (amount - receipt.getChange());
    }
}
