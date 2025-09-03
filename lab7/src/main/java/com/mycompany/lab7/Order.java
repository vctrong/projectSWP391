/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab7;

/**
 *
 * @author Vo Chi Trong - CE191062
 */
public class Order {

    private String id;
    private Plant p;
    private int qty;

    public Order(String id, Plant p, int qty) {
        this.id = id;
        this.p = p;
        this.qty = qty;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Plant getP() {
        return p;
    }

    public void setP(Plant p) {
        this.p = p;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getTotal() {
        if (p instanceof Flower) {
            Flower f = (Flower) p;
            if (f.isRare()) {
                return f.getBasePrice() * 1.5 * getQty();
            } else {
                return f.getBasePrice() * getQty();
            }
        } else if (p instanceof Tree) {
            Tree t = (Tree) p;
            if (t.getLength() >= 5) {
                return t.getBasePrice() * 1.2 * getQty();
            } else {
                return t.getBasePrice() * getQty();
            }
        }
        return 0.0;
    }

    public String printInfo() {
        return "Order #" + getId() + ": " + getQty() + " x " + getP().getName() + " = " + getTotal() + "\n";
//        return String.format("Order #%s: %d x %s = %.2f\n", getId(), getQty(), getP().getName(), getTotal());
    }

}
