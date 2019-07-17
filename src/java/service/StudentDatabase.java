package service;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import bean.Student;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sarkhanrasullu
 */
public class StudentDatabase {

    public static Connection connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/student";
        String username = "root";
        String password = "root";
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }

    public static List<Student> getAll() {
        List<Student> result = new ArrayList<>();
        try (Connection conn = connect()) {
            //chay
            PreparedStatement stmt = conn.prepareStatement("select * from student");//lotka
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt(1);
                String sname = rs.getString(2);
                String ssurname = rs.getString(3);
                Integer age = rs.getInt("age");
                result.add(new Student(id, sname, ssurname, age));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }

    public static List<Student> getAll(String name, String surname, Integer age) {
        if (name == null && surname == null && age == null) {
            return getAll();
        }
        List<Student> result = new ArrayList<>();
        try (Connection conn = connect()) {
            //chay
            PreparedStatement stmt = conn.prepareStatement(
                    "select * from student where name like ? and surname like ?");//lotka
            stmt.setString(1, "%" + name + "%");
            stmt.setString(2, "%" + surname + "%");
            stmt.execute();
            ResultSet rs = stmt.getResultSet();

            while (rs.next()) {
                int id = rs.getInt("id");
                String sname = rs.getString("name");
                String ssurname = rs.getString("surname");
                Integer sage = rs.getInt("age");
                result.add(new Student(id, sname, ssurname, sage));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return result;
    }

    public static boolean update(Student s) {
        try (Connection conn = connect()) {
            //chay
            PreparedStatement stmt = conn.prepareStatement("update student set name=?, surname=?, age=? where id=?");
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getSurname());
            stmt.setInt(3, s.getAge());
            stmt.setInt(4, s.getId());

            stmt.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public static int add(Student s) {
        try (Connection conn = connect()) {
            //chay
            PreparedStatement stmt = conn.prepareStatement("insert into student(name,surname,age) values(?,?,?)");//lotka
            stmt.setString(1, s.getName());
            stmt.setString(2, s.getSurname());
            stmt.setInt(3, s.getAge());
            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public static int delete(int id) {
        try (Connection conn = connect()) {
            //chay
            PreparedStatement stmt = conn.prepareStatement("delete from student where id=?");//lotka
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
