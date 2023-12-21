/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author amrkh
 */
public class BasicSandwitch implements Sandwitch{

    @Override
    public double getCost() {
        return 100;
    }

    @Override
    public String description() {
        return "Large Sandwitch";
    }
    
}
