package com.LiHongxin.week5;

import com.LiHongxin.DAO.UserDAO;
import com.LiHongxin.model.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet", value = "/Login")
public class LoginServlet extends HttpServlet {
    Connection con = null;
    public void init() throws ServletException{
        super.init();
        /*try { Class.forName(getServletConfig().getServletContext().getInitParameter("driver"));
            con = DriverManager.getConnection(getServletConfig().getServletContext().getInitParameter("url"),
                    getServletConfig().getServletContext().getInitParameter("Username"),
                    getServletConfig().getServletContext().getInitParameter("Password"));
        } catch (Exception e) {
            System.out.println(e); }*/
        con = (Connection) getServletContext().getAttribute("con");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("name");
        String password= request.getParameter("password");
        System.out.println(username + password);
        PrintWriter writer = response.getWriter();
        UserDAO userDao = new UserDAO();
        try {
            user user = userDao.findByUsernamePassword(con,username,password);
            if(user!=null) {
                request.setAttribute("user",user);
                request.getRequestDispatcher("WEB-INF/views/userInfo.jsp").forward(request,response);
            }
            else {
                request.setAttribute("message","username or Password Error!!!");
                request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,response);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        /*
        try {
            if( con != null){
                String sql = "SELECT * FROM usertable WHERE name=? AND password=?;";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1,username);
                ps.setString(2,password);
                ResultSet rs = ps.executeQuery();
                if(rs.next()){
                    writer.println("Login Success!!!");
                    writer.println("Welcome "+name+".");
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("username",rs.getString(1));
                    request.setAttribute("password",rs.getString(2));
                    request.setAttribute("email",rs.getString(3));
                    request.setAttribute("gender",rs.getString(4));
                    request.setAttribute("birthdate",rs.getString(5));
                    request.getRequestDispatcher("userInfo.jsp").forward(request,response);
                }else{
                    //writer.print("Username or Password Error!!!");
                    PrintWriter printWriter =response.getWriter();
                    request.setAttribute("message","Username Or Password Error!!");
                    request.getRequestDispatcher("login.jsp").forward(request,response);
                }
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        */
    }
}
