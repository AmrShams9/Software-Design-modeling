/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Command;

/**
 *
 * @author amrkh
 */
public class Executer {
    final static int TV = 0;

    
    public static void main(String[] args) {
        // TODO code application logic here
        RemoteControll remoteControl = new RemoteControll();
        Television tv = new Television();
        TurnOnTelevision turnOnTelevision = new TurnOnTelevision(tv);
        TurnOffTelevision turnOffTelevision = new TurnOffTelevision(tv);
        remoteControl.addCommand(TV, turnOnTelevision, turnOffTelevision);
        remoteControl.onClickOn(TV);
        remoteControl.onClickOff(TV);
    }
    
}
