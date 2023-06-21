/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amrkh
 */
public class Course implements Subject {
     private String name;
    private String avalability;
    private List<Observer> observerlist;
    public Course(String name){
        this.name = name;
        observerlist = new ArrayList<>();
    }
    public void setAvalability(boolean avalible ){
        avalability = this.name + (avalible ? "Available" : "Not Available");
        notifyALL();
    }
    @Override
     public void subscribe(Observer observer){
         observerlist.add(observer);
         
     }
     @Override
    public void unsubscribe(Observer observer){
        observerlist.remove(observer);
        
    }
    @Override
    public void notifyALL(){
        for (Observer observer : observerlist) {
            observer.update(avalability);
            
        }
        
    }
    
    
}
