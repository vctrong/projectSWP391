/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

/**
 *
 * @author Vo Chi Trong - CE191062
 */
public class Flower extends Plant {

    private boolean rare;

    public Flower(boolean rare, String name, double basePrice) {
        super(name, basePrice);
        this.rare = rare;
    }

    public boolean isRare() {
        return rare;
    }

    public void setRare(boolean rare) {
        this.rare = rare;
    }

}
