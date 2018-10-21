package global;

import java.sql.*;

public class dbConnector {
    private Connection con;

    public dbConnector() {
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet querySelect(String query) {
        ResultSet rset = null;
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            rset = stmt.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rset;
    }
}