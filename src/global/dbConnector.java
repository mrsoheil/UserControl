package global;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnector {
    public dbConnector() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection con = DriverManager.getConnection("jdbc:://mysql://localhost:3306/db","root","");





            } catch (SQLException e) {
                e.printStackTrace();
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


}
