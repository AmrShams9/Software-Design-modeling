/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Singelton;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author amrkh
 */
public class Single {
    private Integer[] numbers = {1, 2, 3 , 4, 5 , 6, 7};
    private List<Integer> list = Arrays.asList(numbers);
    private static Single instance;
    public static Single getInstance(){
        if(instance == null){
            instance = new Single();
        }
        return instance;
    }
    private Single(){
        System.out.println("Object Created..!");
        Collections.shuffle(list);
        System.out.println(this.hashCode());
    }
    
    
    
    
    public void printer(){
        for (Integer i : list) {
            System.out.println(" " + i.toString());
            
        }
        System.out.println();
    }
    
}
