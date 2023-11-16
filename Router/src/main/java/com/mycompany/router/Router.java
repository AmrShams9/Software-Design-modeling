/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.router;



import java.util.ArrayList;
import java.util.List;

public class Router {
    private int maxConnections;
    private List<Device> connectedDevices;

    public Router(int maxConnections) {
        this.maxConnections = maxConnections;
        this.connectedDevices = new ArrayList<>();
    }

    public synchronized int connectDevice(Device device) {
        if (connectedDevices.size() < maxConnections) {
            connectedDevices.add(device);
            return connectedDevices.size();
        } else {
            System.out.println("- " + device.getDeviceID() + "(" + device.getDeviceType() + ") arrived and waiting");
            return -1; // Device is waiting
        }
    }

    public synchronized void disconnectDevice(Device device) {
        connectedDevices.remove(device);
    }
}

