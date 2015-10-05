/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Daan
 */
public class Device {
    
    private String MACAddress;
    private String operatingSystem;

    public Device(String MACAddress, String operatingSystem) {
        this.MACAddress = MACAddress;
        this.operatingSystem = operatingSystem;
    }
    
    public String getManufacturer(){
        //TODO - get manufacturer based on MAC address
        return "";
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }
}
