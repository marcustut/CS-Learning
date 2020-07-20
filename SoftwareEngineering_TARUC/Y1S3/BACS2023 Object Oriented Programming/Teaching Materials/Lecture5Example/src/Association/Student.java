/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Association;

/**
 *
 * @author MaLaR
 */
public class Student {

    private String name;
    private String matrix;
    private Course[] courseList;  //showing association
    private int numOfCourse=0;

    public Student(String n, String m, String c) {
        name = n;
        matrix = m;
        courseList = new Course[10];  //showing association
    }

    public String getName() {
        return name;
    }

    public String getMatrix() {
        return matrix;
    }

    public void registerCourse(Course cs) {
        courseList[numOfCourse] = cs;
        numOfCourse++;
    }

    public int getNumOfCourse() {
        return numOfCourse;
    }

    public void printAllInfo() {
        System.out.println("\nSTUDENT NAME :" + name);
        System.out.println("NUMBER OF SUBJECT(s) TAKEN :"
                + numOfCourse);
        System.out.println("LIST OF SUBJECT(s) TAKEN :");
        for (int i = 0; i < numOfCourse; i++) {
            Course s = courseList[i];
            System.out.println((i + 1) + ". " + s.getName());
        }
    }
}
