package edu.course.lab02;
public class BankAccount {
    private int balance;
    public BankAccount(int balance){
        if (balance < 0) {
            throw new IllegalArgumentException("Баланс не может быть отрицательным");
        }
        this.balance = balance;
    }
    public void deposit(int amount){
        if (amount > 0){
            this.balance += amount;
        }
        else {
            throw new IllegalArgumentException("Некоректная сумма");
        }
    }
    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount){
            this.balance -= amount;
        }
        else {
            throw new IllegalArgumentException("Некоректная сумма");
        }
    }
    public int getBalance(){
        return balance;
    }
}
