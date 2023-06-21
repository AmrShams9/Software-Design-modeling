/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author amrkh
 */
public class Excuter {
    public static void main(String[] args) {
        List<String> sites = Arrays.asList("twitter", "facebook" ,"youtube", "pintrest", "udemy", "udacity", "Booking");
        InternetServiceProvider isp = new InternetProxy();
        for (String site : sites) {
            System.out.println(isp.serveSite(site));
            
        }
    }
    
}
