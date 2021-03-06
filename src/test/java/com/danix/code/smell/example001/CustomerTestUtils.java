package com.danix.code.smell.example001;

/**
 * @author  danix
 */
public class CustomerTestUtils {

    private static CustomerFactory customerFactory = new CustomerFactory();

    static Customer getCompanyCustomer(Account account) {
        Customer customer = customerFactory.createCompany("company", "company@mail.com", account, 0.50);
        account.setCustomer(customer);
        return customer;
    }

    static Customer getPersonCustomer(Account account) {
        Customer customer = customerFactory.createPerson("danix", "dan", "dan@mail.com", account);
        account.setCustomer(customer);
        return customer;
    }

    static Customer getPersonWithAccount(boolean premium) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        Customer customer = getPersonCustomer(account);
        account.setIban("RO023INGB434321431241");
        account.setMoney(Money.newEuro(34.0));
        return customer;
    }
    static Account getAccount(final boolean premium) {
        AccountType accountType = new AccountType(premium);
        Account account = new Account(accountType, 9);
        account.setIban("RO023INGB434321431241");
        account.setMoney(Money.newEuro(34.0));
        return account;
    }
}