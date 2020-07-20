/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BidirectionalAssociation;

/**
 *
 * @author MaLaR
 */
public class TestAssociate {

    public static void main(String args[]) {
        Course cs1 = new Course("OOP", "SCP3103", 3);
        Course cs2 = new Course("TP1", "SCJ1013", 3);
        Course cs3 = new Course("TP2", "SCJ1213", 3);
        Course cs4 = new Course("KP", "SCP2113", 3);
        Student s1 = new Student("Ali", "AC0021", "2SCK");
        Student s2 = new Student("Abu", "AC0022", "3SCK");
        Student s3 = new Student("Ben", "AC0023", "3SCS");
        cs1.addStudent(s1);
        cs1.addStudent(s2);
        cs1.addStudent(s3);
        cs2.addStudent(s2);
        cs3.addStudent(s2);
       
        s1.printAllInfo();
        s2.printAllInfo();
        s3.printAllInfo();
    }
}
