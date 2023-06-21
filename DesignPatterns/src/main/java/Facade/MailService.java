/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Facade;

/**
 *
 * @author amrkh
 */
public class MailService {

    public void sendConfirmationMail(User user) {
        System.out.println("Sending mail to " + user.getName());
    }

}
