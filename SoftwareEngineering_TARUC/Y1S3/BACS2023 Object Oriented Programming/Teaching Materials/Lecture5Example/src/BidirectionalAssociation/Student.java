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
public class Student {

    private String name;
    private String matrix;
    private String major;
    private Course[] courseList;
    private int numOfCourse;

    public Student(String n, String m, String j) {
        name = n;
        matrix = m;
        major = j;
        courseList = new Course[4];
    }

    public String getName() {
        return name;
    }

    public String getMatrix() {
        return matrix;
    }

    public String getMajor() {
        return major;
    }

    public void register(Course cs) {
        courseList[numOfCourse] = cs;
        numOfCourse++;
    }

    public int getNumOfCourse() {
        return numOfCourse;
    }

    public void printAllInfo() {
        System.out.println("\nSTUDENT NAME :" + name);
        System.out.println("NUMBER OF SUBJECT(s)TAKEN:" + numOfCourse);
        System.out.println("LIST OF SUBJECT(s) TAKEN :");
        for (int i = 0; i < numOfCourse; i++) {
            Course s = (Course) courseList[i];
            System.out.println((i + 1) + ". " + s.getName());
        }
    }
}
