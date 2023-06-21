/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Observer;

/**
 *
 * @author amrkh
 */
public interface Subject {
    public void subscribe(Observer observer);
    public void unsubscribe(Observer observer);
   public void notifyALL();
    
}
