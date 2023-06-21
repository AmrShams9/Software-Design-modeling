/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author amrkh
 */
public class User {
    private String id;
    private String name;
    public double balance;
    private String currency;
    private String accountNbr;

    public User(String id, String name, double balance, String currency, String accountNbr) {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.currency = currency;
        this.accountNbr = accountNbr;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setAccountNbr(String accountNbr) {
        this.accountNbr = accountNbr;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public String getAccountNbr() {
        return accountNbr;
    }
}

