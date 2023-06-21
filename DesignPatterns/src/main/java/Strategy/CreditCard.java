/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Strategy;

/**
 *
 * @author amrkh
 */


public class CreditCard {

    private int amount = 1_000;
    private String number;
    private String date;
    private String cvv;

    public CreditCard(String num, String date, String cvv) {
        this.number = num;
        this.date = date;
        this.cvv = cvv;
    }

    // Setters
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // Getters
    public int getAmount() {
        return amount;
    }

    public String getNumber() {
        return number;
    }

    public String getDate() {
        return date;
    }

    public String getCvv() {
        return cvv;
    }
}

