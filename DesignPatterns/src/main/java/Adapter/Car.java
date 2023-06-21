/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author amrkh
 */
public class Car implements Vehicle{

    @Override
    public void accelerate() {
        System.out.println("Car starts Moving");
        
    }

    @Override
    public void pushBreak() {
        System.out.println("Car Stops");
    }

    @Override
    public void soundHorn() {
        System.out.println("Beep Beep....!");
    }
    
}
