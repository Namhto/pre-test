package com.priceminister.account;

public class IllegalAddedAmountException extends RuntimeException {

	private Double amount;

    public IllegalAddedAmountException(Double amount) {
        this.amount = amount;
    }
    
    public String toString() {
        return "Illegal added amount: " + this.amount;
    }
}
