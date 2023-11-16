/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.router;




import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Device extends Thread {
    
    private String deviceID;
    private String deviceType;
    private String routerName;
    private ArrayList<String> connectionHistory;
    private ArrayList<String> browsingHistory;
    private boolean connectionStatus;
     private Router router;
    private Semaphore semaphore;
    public Device(String deviceID, String deviceType, Router router, Semaphore semaphore) {
        this.deviceID = deviceID;
        this.deviceType = deviceType;
        this.router = router;
        this.semaphore = semaphore;
        this.browsingHistory = new ArrayList<>();
        this.connectionStatus = true;
    }//

    public Device(String deviceID, String deviceType, String routerName) {
        this.deviceID = deviceID;
        this.deviceType = deviceType;
        this.routerName = routerName;
        this.connectionHistory = new ArrayList<String>();
        this.connectionStatus = false;
        this.browsingHistory = new ArrayList<String>();
    }
     public Device(String deviceID, String deviceType,Semaphore semaphors) {
        this.deviceID = deviceID;
        this.deviceType = deviceType;
        //this.routerName = routerName;
        this.connectionHistory = new ArrayList<String>();
        this.connectionStatus = false;
        this.browsingHistory = new ArrayList<String>();
        
    }
      public Device( String deviceID, String deviceType) {
        this.deviceID = deviceID;
        this.deviceType = deviceType;
        this.connectionStatus = false;
        
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getRouterName() {
        return routerName;
    }

    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public ArrayList<String> getConnectionHistory() {
        return connectionHistory;
    }

    public void setConnectionHistory(ArrayList<String> connectionHistory) {
        this.connectionHistory = connectionHistory;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
    
    public ArrayList<String> getBrowsingHistory() {
        return browsingHistory;
    }

    public void setBrowsingHistory(ArrayList<String> browsingHistory) {
        this.browsingHistory = browsingHistory;
    }
    
   public void onlineActivity(String activity) {
    if (connectionStatus) {
        // If the device is connected to the network, handle the online activity.
        String timestamp = getCurrentTimestamp();
        String activityLog = activity + " at " + timestamp;
        browsingHistory.add(activityLog);
    } else {
        // If the device is not connected, you can log a message or take some other action.
        System.out.println("Device is not connected to the network. Cannot perform online activity: " + activity);
    }
}


    @Override
    public void run() {
        try {
            // Arrived
            System.out.println("- (" + deviceID + ")(" + deviceType + ") arrived");

            // Acquire a connection
            semaphore.acquire();
            int connectionNumber = router.connectDevice(this);

            // Login
            System.out.println("- Connection " + connectionNumber + ": " + deviceID + " login");

            // Simulate online activity
            onlineActivity("preforms online activity");
            System.out.println(connectionNumber + "  " + deviceID + "   preforms online activity");

            // Logout
            System.out.println("- Connection " + connectionNumber + ": " + deviceID + " Logged out");

            // Release the connection
            router.disconnectDevice(this);
            semaphore.release();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private String getCurrentTimestamp() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(new Date());
    }
    
    public boolean connectOrDisconnectDevice(String routerName, boolean connectionStatus) {
        if (routerName.equals(this.routerName)) {
            // If the router name matches the device's routerName, update the connection status.
            this.connectionStatus = connectionStatus;

            // Add the connection status and timestamp to the connectionHistory.
            String status = connectionStatus ? "Connected" : "Disconnected";
            String timestamp = getCurrentTimestamp();

            String historyEntry = status + " at " + timestamp;
            connectionHistory.add(historyEntry);

            return true; // Return true to indicate a successful connection update.
        } else {
            return false; // Return false to indicate that the router name doesn't match.
        }
    }
    public static void displayDeviceHistory(Device device) {
        System.out.println("Device ID: " + device.getDeviceID());
        System.out.println("Connection History:");
        for (String entry : device.getConnectionHistory()) {
            System.out.println(entry);
        }
        System.out.println("Browsing History:");
        for (String entry : device.getBrowsingHistory()) {
            System.out.println(entry);
        }
        System.out.println();
    }
    
}

    

