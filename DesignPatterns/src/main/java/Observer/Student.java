/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author amrkh
 */
public class Student implements Observer {
    private String name;
    public Student(String name){
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(this.name +" has new Notification");
    }
    
}
