/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author amrkh
 */
public class Cheese extends SandwitchDecorator{
    public Cheese(Sandwitch sandwitch){
        super(sandwitch);
    }
    public double getCost() {
    return this.sandwitch.getCost() + 10;
    }

    @Override
    public String description() {
    return this.sandwitch.description() + " with cheese";
    }
    
    
}
