package org.example;

import org.example.task1.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount1 = new BankAccount();
        bankAccount1.setBalance(10000);
        bankAccount1.print();
    }

}