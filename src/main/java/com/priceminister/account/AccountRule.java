package com.priceminister.account;

/**
 * Checks if the requested operation is permitted.
 */
public interface AccountRule {
    
    /**
     * Checks if the account balance is OK after a withdrawal of an amount
     * for the specific type of account.
     * @param currentBalance - the account balance
     * @param withdrawnAmount - the withdrawn amount
     * @return true if the operation is permitted, false otherwise
     */
    boolean withdrawPermitted(Double currentBalance, Double withdrawnAmount);

    /**
     * Checks if the added amount is OK
     * for the specific type of account.
     * @param addedAmount - the added amount
     * @return true if the operation is permitted, false otherwise
     */
    boolean addPermitted(Double addedAmount);
}
