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
public class Manufacturer {

    private String name;
    private int amount;

    public Manufacturer(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public void addOneToAmount() {
        amount = amount + 1;
    }
    
    public void addAmount(int amount){
        this.amount += amount;
    }

    @Override
    public String toString() {
        return (this.name + ", " + amount);
    }

}
