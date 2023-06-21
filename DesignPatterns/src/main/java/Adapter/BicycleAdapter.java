/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author amrkh
 */
public class BicycleAdapter implements Vehicle {
    private Bicycle bike;
    public BicycleAdapter(Bicycle bike){
        this.bike  = bike;
    }
    @Override
    public void accelerate() {
        this.bike.pedal();
    }

    @Override
    public void pushBreak() {
        this.bike.stop();
    }

    @Override
    public void soundHorn() {
        this.bike.ringBell();
    }
    
}
