package edu.course.lab02;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankAccountTest {

    @Test
    void returnsInitialBalance() {
        BankAccount account = new BankAccount(100);
        int result = account.getBalance();
        assertEquals(100, result);
    }

    @Test
    void allowsZeroInitialBalance() {
        BankAccount account = new BankAccount(0);
        int result = account.getBalance();
        assertEquals(0, result);
    }

    @Test
    void rejectsNegativeInitialBalance() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount(-10));
    }

    @Test
    void depositIncreasesBalance() {
        BankAccount account = new BankAccount(100);
        account.deposit(50);
        int result = account.getBalance();
        assertEquals(150, result);
    }

    @Test
    void rejectsZeroDeposit() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertEquals(100, account.getBalance());
    }

    @Test
    void rejectsNegativeDeposit() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-10));
        assertEquals(100, account.getBalance());
    }

    @Test
    void withdrawReducesBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(30);
        int result = account.getBalance();
        assertEquals(70, result);
    }

    @Test
    void allowsWithdrawalOfEntireBalance() {
        BankAccount account = new BankAccount(100);
        account.withdraw(100);
        int result = account.getBalance();
        assertEquals(0, result);
    }

    @Test
    void rejectsWithdrawalExceedingBalance() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(150));
        int result = account.getBalance();
        assertEquals(100, result);
    }

    @Test
    void rejectsZeroWithdrawal() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertEquals(100, account.getBalance());
    }

    @Test
    void rejectsNegativeWithdrawal() {
        BankAccount account = new BankAccount(100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10));
        assertEquals(100, account.getBalance());
    }
}