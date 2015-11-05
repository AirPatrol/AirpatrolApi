/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Daan
 */
public class Whitelist {
    
    private List<String> whiteList;
    
    public Whitelist(){
        whiteList = new ArrayList<>();
        whiteList.add("samsung");
        whiteList.add("apple");
        whiteList.add("htc");
        whiteList.add("cisco");
        whiteList.add("azurewave");
        whiteList.add("liteon");
        whiteList.add("hon hai");
    }
    
    public List<String> getWhiteList(){
        return whiteList;
    }
}
