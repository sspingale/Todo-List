import java.sql.*;
// import java.util.*;
// import javax.swing.*;

public class DB {
    public static Connection conn = null;
    public static Connection dbconnect(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/todolist", "root", "");
            return conn;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}