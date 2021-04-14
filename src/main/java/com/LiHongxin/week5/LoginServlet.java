package com.LiHongxin.week5;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username= request.getParameter("username");
        String password= request.getParameter("password");

        PrintWriter writer = response.getWriter();
        writer.println("<br>username :"+username);
        writer.println("<br>password :"+password);
        response.setContentType("text/html");
        PrintWriter out= response.getWriter();
        String sql="select * from usertable where " +
                "username=" +"'"+username+"'"+
                " and " +
                "password=" +"'"+password+"';";
        try {
            Statement st =con.createStatement();
            ResultSet rs= st.executeQuery(sql);
            if (rs.next()){
                out.println("Login Success!!!");
                out.println("Welcome"+username);
                request.setAttribute("id",rs.getInt("id"));
                request.setAttribute("username",rs.getString("username"));
                request.setAttribute("password",rs.getString("password"));
                request.setAttribute("email",rs.getString("email"));
                request.setAttribute("gender",rs.getString("gender"));
                request.setAttribute("birthdate",rs.getString("birthday"));
            }
            else
            {
                out.println("Username or Password Error!!!");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
