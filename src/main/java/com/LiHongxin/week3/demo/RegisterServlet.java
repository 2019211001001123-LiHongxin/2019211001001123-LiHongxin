package com.LiHongxin.week3.demo;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(urlPatterns = {"/register"},loadOnStartup = 1)
public class RegisterServlet extends HttpServlet {
    Connection con=null;
    @Override
    public void init() throws ServletException{
        super.init();
        con= (Connection) getServletContext().getAttribute("con");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer= response.getWriter();
        String username= request.getParameter("username");
        String password= request.getParameter("password");
        String email= request.getParameter("email");
        String gender= request.getParameter("gender");
        String birthday= request.getParameter("birthdate");



        try{
            Statement st=con.createStatement();//
            String sql="insert into usertable ( username,password,email,gender,birthday ) "+
                    " values ('"+username+"','"+password+"','"+email+"','"+gender+"','"+birthday+"'); ";
            System.out.println("sql"+sql);
            int n= st.executeUpdate(sql);
            System.out.println("n-->"+n);
            sql="select id,username,password,email,gender,birthday from usertable";
            ResultSet rs= st.executeQuery(sql);
            PrintWriter out = response.getWriter();
            request.setAttribute("rsname",rs);
            request.getRequestDispatcher("userList.jsp").forward(request,response);
        }catch( SQLException e){
            e.printStackTrace();
        }
    }

}
