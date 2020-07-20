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
public class Course {

    private String name;
    private String code;
    private int section;
    private Student[] stuList;
    private int numOfStudent;

    public Course(String n, String c, int s) {
        name = n;
        code = c;
        section = s;
        stuList = new Student[60];
    }

    public String getName() {
        return name;
    }

    public void addStudent(Student st) {  //addStudent
        stuList[numOfStudent] = st;
        numOfStudent++;
        st.register(this);
    }

    

}
