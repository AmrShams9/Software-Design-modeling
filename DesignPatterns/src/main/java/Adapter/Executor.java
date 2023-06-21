/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

/**
 *
 * @author amrkh
 */
public class Executor {
    public static void main(String[] args) {
        Vehicle car = new Car();
        useVehicle(car);
        Vehicle bike = new BicycleAdapter(new Bicycle());
        useVehicle(bike);
    }

    private static void useVehicle(Vehicle car) {
        car.accelerate();
        car.pushBreak();
        car.soundHorn();
    }
    
}
