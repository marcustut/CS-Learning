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
public class Proton extends Car {

    //Proton extends Car and thus inherits all methods from Car (except final and static)
    //Proton can also define all its specific functionality
    public void ProtonStartDemo() {
        Engine ProtonEngine = new Engine();
        ProtonEngine.start();
    }
}
