/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Decorator;


public class Executor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Sandwitch mysandwitch = new Cheese(new BasicSandwitch());
        System.out.println("Description  :  " + mysandwitch.description());
        System.out.println("Cost = " + mysandwitch.getCost());
    }
    
}
