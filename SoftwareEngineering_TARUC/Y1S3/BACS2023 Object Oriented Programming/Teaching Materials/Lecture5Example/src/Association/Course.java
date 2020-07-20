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
public class Course {

    private String name;
    private String code;
    private int section;

    public Course(String n, String c, int s) {
        name = n;
        code = c;
        section = s;
    }

    public String getName() {
        return name;
    }
}
