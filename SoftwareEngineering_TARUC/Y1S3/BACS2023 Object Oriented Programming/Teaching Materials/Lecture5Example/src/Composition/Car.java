/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Composition;

/**
 *
 * @author MaLaR
 */
class Car {
    // Methods implementation and class/Instance members

    private String color;
    private int maxSpeed;

    public void carInfo() {
        System.out.println("Car Color= " + color + " Max Speed= " + maxSpeed);
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
