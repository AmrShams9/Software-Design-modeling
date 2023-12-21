/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author amrkh
 */
public class Beef extends SandwitchDecorator
{
    public Beef(Sandwitch sandwitch){
        super(sandwitch);
        
    }
    @Override
    public double getCost() {
    return this.sandwitch.getCost() + 50;
    }

    @Override
    public String description() {
    return this.sandwitch.description() + " with  2 Beef slices";
    }
    
    
    
}
