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
public class RelationsDemo {

	public static void main(String[] args) {		
		Proton myProton = new Proton();
		myProton.setColor("blue");
		myProton.setMaxSpeed(180);
		myProton.carInfo();
		myProton.ProtonStartDemo();
	}
}