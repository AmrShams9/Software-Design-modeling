/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singelton;

/**
 *
 * @author amrkh
 */
public class Executor {
    public static void main(String[] args) {
        
        Single single1 = Single.getInstance();
        single1.printer();
        Single single2 = Single.getInstance();
        single2.printer();
        
    }
    
}
