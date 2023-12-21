/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

/**
 *
 * @author amrkh
 */
public class SandwitchDecorator implements Sandwitch{
    Sandwitch sandwitch;
    
    public SandwitchDecorator(Sandwitch sandwitch){
        this.sandwitch = sandwitch;
    }

    @Override
    public double getCost() {
    return this.sandwitch.getCost();
    }

    @Override
    public String description() {
    return this.sandwitch.description();
    }
    
    
}
