/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

import java.util.List;
import java.util.Arrays;

/**
 *
 * @author amrkh
 */
public class InternetProxy implements InternetServiceProvider {
    private List<String> blockedSites = Arrays.asList("twitter", "facebook" ,"youtube", "pintrest");

    @Override
    public String serveSite(String url) {
        internetLog(url);
        if(blockedSites.contains(url)){
            return "This website is blocked";
        }
        return new Vodafone().serveSite(url);
    }

    private void internetLog(String url) {
        System.out.printf("[%d] -> %s requested \n" , System.currentTimeMillis(), url);
    }
    
    
}
