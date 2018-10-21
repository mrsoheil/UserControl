package Controler;


import global.dbConnector;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "loginServlet")
public class login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        RequestDispatcher dispatcher = req.getRequestDispatcher("/login.jsp");

        String username, password;
        username = req.getParameter("username");
        password = req.getParameter("password");

        String name=null;
        int uid = 0;

        dbConnector db = new dbConnector();
        ResultSet rset = db.querySelect("select * from tbl_user where username='"+username+"' and password='"+password+"'  ");

        try {
            rset.first();

            System.out.println(rset.getString(1));
            System.out.println("=>");
            System.out.println(rset.getString(4));

            name = rset.getString(4);

            uid = rset.getInt(1);

            req.setAttribute("fullname", name );

        } catch (SQLException e) {
            e.printStackTrace();
        }

        dispatcher.forward(req, resp);

    }
}
