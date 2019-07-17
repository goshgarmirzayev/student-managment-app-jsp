/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import service.StudentDatabase;
import bean.Student;

/**
 *
 * @author Goshgar
 */
public class Test {

    public static void main(String[] args) {
        Student s = new Student("Aliabbas", "Mehtiyev", 21);
        StudentDatabase.add(s);
        for (Student student : StudentDatabase.getAll()) {
            System.out.println(student);
        }
    }

}
