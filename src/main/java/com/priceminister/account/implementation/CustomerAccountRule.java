/*
 * =============================================================================
 *
 *   PRICE MINISTER APPLICATION
 *   Copyright (c) 2000 Babelstore.
 *   All Rights Reserved.
 *
 *   $Source$
 *   $Revision$
 *   $Date$
 *   $Author$
 *
 * =============================================================================
 */
package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccountRule implements AccountRule {

    /* (non-Javadoc)
     * @see com.priceminister.account.AccountRule#withdrawPermitted(java.lang.Double, java.lang.Double)
     */
    public boolean withdrawPermitted(Double currentBalance, Double withdrawnAmount) {
        boolean withdrawingPositiveAmount = withdrawnAmount >= 0;
        boolean thereIsEnoughBalance = currentBalance >= withdrawnAmount;
        return withdrawingPositiveAmount && thereIsEnoughBalance;
    }

}
