/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

/**
 *
 * @author amrkh
 */
public class Vodafone implements InternetServiceProvider {
    
    private  int browsingSpeed = 10;
    @Override
    public String serveSite(String url) {
        return String.format("https:/%s.com", url);
    }
    public int getBrowsingSpeed(){
        return browsingSpeed;
    }
    
}
