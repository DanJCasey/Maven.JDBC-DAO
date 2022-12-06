package daos;

import com.mysql.jdbc.Driver;
import java.sql.SQLException;
import java.sql.*;
public class Connect {
    private static final String URL =  "jdbc:mysql://localhost:3306";
    private static final String USER = "surg";
    private static final String PASS = "Surgles92";

    public static Connection getConnection() {
        try {
            DriverManager.registerDriver(new Driver());
            System.out.println("Success!");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ex) {
            throw new RuntimeException("Error");
        }
    }
}
