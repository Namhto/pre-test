package com.priceminister.account;


import static org.junit.Assert.*;

import org.junit.*;

import com.priceminister.account.implementation.*;


/**
 * Please create the business code, starting from the unit tests below.
 * Implement the first test, the develop the code that makes it pass.
 * Then focus on the second test, and so on.
 * 
 * We want to see how you "think code", and how you organize and structure a simple application.
 * 
 * When you are done, please zip the whole project (incl. source-code) and send it to recrutement-dev@priceminister.com
 * 
 */
public class CustomerAccountTest {
    
    private Account customerAccount;
    private AccountRule rule = new CustomerAccountRule();

    @Before
    public void setUp() {
        customerAccount = new CustomerAccount();
    }
    
    /**
     * Tests that an empty account always has a balance of 0.0, not a NULL.
     */
    @Test
    public void testAccountWithoutMoneyHasZeroBalance() {
        assertNotNull("Balance of an empty account is null but should not", customerAccount.getBalance());
        assertEquals(Double.valueOf(0.0), customerAccount.getBalance());
    }
    
    /**
     * Adds money to the account and checks that the new balance is as expected.
     */
    @Test
    public void testAddPositiveAmount() {
        customerAccount.add(10.0, rule);
        assertEquals(Double.valueOf(10.0), customerAccount.getBalance());
        customerAccount.add(5.0, rule);
        assertEquals(Double.valueOf(15.0), customerAccount.getBalance());
    }

    @Test(expected = IllegalAddedAmountException.class)
    public void testAddIllegalNegativeAmount() {
        customerAccount.add(-10.0, rule);
    }
    
    /**
     * Tests that an illegal withdrawal throws the expected exception.
     * Use the logic contained in CustomerAccountRule; feel free to refactor the existing code.
     */
    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalBalance() {
        customerAccount.withdrawAndReportBalance(10.0, rule);
    }

    @Test(expected = IllegalBalanceException.class)
    public void testWithdrawAndReportBalanceIllegalNegativeWithdrawnAmount() {
        customerAccount.withdrawAndReportBalance(-10.0, rule);
    }

    @Test
    public void testWithdrawAndReportBalanceSucceed() {
        customerAccount.add(50.0, rule);
        assertEquals(Double.valueOf(40.0), customerAccount.withdrawAndReportBalance(10.0, rule));
    }

}
