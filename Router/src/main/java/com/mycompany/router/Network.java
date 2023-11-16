/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.router;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Network {
    private static int N;
    private static int TC;
    private static List<Device> TC_lines;
    private static Semaphore semaphore;
    private static Router router;  // Add reference to Router
   
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the number of WI-FI Connections?");
        N = scanner.nextInt();

        System.out.println("What is the number of devices Clients want to connect?");
        TC = scanner.nextInt();

        scanner.nextLine(); // Consume the newline character

        // Initialize the Router and Semaphore
        router = new Router(N);
        semaphore = new Semaphore(N);

        TC_lines = new ArrayList<>(N);

        for (int i = 0; i < TC; i++) {
            System.out.println("Enter Device Name:");
            String name = scanner.nextLine();
            System.out.println("Enter Device Type:");
            String type = scanner.nextLine();
            TC_lines.add(new Device(name, type, router, semaphore));  // Pass Router and Semaphore
        }

        // Create and start devices
        for (Device device : TC_lines) {
            device.start();
            //device.displayDeviceHistory(device);
        }
        

        // Display connection and online activity information
        for (Device device : TC_lines) {
    int connectionNumber = router.connectDevice(device);

    if (connectionNumber != -1) {
        System.out.println("- Connection " + connectionNumber + ": " + device.getDeviceID() + " Occupied");
        // Perform online activity or other actions here...

        // Disconnect the device
        router.disconnectDevice(device);
        System.out.println("- Connection " + connectionNumber + ": " + device.getDeviceID() + " log out");
    } else {
        System.out.println("- " + device.getDeviceID() + "(" + device.getDeviceType() + ") arrived and waiting");
    }
}

    }
}
