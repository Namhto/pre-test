package com.priceminister.account.implementation;

import com.priceminister.account.*;


public class CustomerAccount implements Account {

    private Double balance = 0.0;

    public void add(Double addedAmount, AccountRule rule) throws IllegalAddedAmountException {
        if (rule.addPermitted(addedAmount)) {
            balance += addedAmount;
        } else {
            throw new IllegalAddedAmountException(addedAmount);
        }
    }

    public Double getBalance() {
        return balance;
    }

    public Double withdrawAndReportBalance(Double withdrawnAmount, AccountRule rule) throws IllegalBalanceException {
        if (rule.withdrawPermitted(balance, withdrawnAmount)) {
            balance -= withdrawnAmount;
            return balance;
        }
        throw new IllegalBalanceException(withdrawnAmount);
    }

}
