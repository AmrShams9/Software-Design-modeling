/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author amrkh
 */
public class TurnOnTelevision implements Command{
    private Television tv;
    public TurnOnTelevision(Television tv){
        this.tv = tv;
    }

    @Override
    public void execute() {
        this.tv.turnOn();
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
