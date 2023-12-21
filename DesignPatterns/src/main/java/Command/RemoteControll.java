/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command;

/**
 *
 * @author amrkh
 */
public class RemoteControll {
    private Command onCommand[];
    private Command offCommand[];
    public RemoteControll(){
        onCommand = new Command[3];
        offCommand = new Command[3];
    }
    public void addCommand(int slotId ,Command onCommand ,Command offCommand ){
        this.onCommand[slotId] = onCommand;
        this.offCommand[slotId] = offCommand;
        
    }
    public void onClickOn(int slotId){
        onCommand[slotId].execute();
        
    }
    public void onClickOff(int slotId){
        offCommand[slotId].execute();
        
    }
}
