package com.LiHongxin.DAO;

import com.LiHongxin.model.user;

import java.sql.*;
import java.util.Date;
import java.util.List;

public class UserDAO implements  IUserDAO {
    public boolean saveUser(Connection con, user user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="insert into usertable(username,password,email,gender,birthDate) values('"+user.getUsername()+"','"+user.getPassword()+"','"+user.getEmail()+"','"+user.getGender()+"','"+user.getBirthDate()+"')";
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("insert "+user.toString()+"success");
            return true;
        }catch(Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int deleteUser(Connection con, user user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="delete from usertable where id="+user.getId();
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("delete "+user.getId()+"success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public int updateUser(Connection con, user user) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="update usertable set username='"+user.getUsername()+"',password='"+user.getPassword()+"',email='"+user.getEmail()+"',gender='"+user.getGender()+"',birth='"+user.getBirthDate()+"' where id="+user.getId();
            createDbStatement.executeUpdate(dbRequire);
            System.out.println("update "+user.getId()+"success");
            return 1;
        }catch(Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public user findById(Connection con, Integer id) throws SQLException {
        try{
            Statement createDbStatement = con.createStatement();
            String dbRequire="select * from usertable where id="+id.toString();
            ResultSet resultDb=createDbStatement.executeQuery(dbRequire);
            while(resultDb.next()) {
                return new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate"));
            }
        }catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public user findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String dbRequire="select * from usertable where username='"+username+"' and password='"+password+"'";
        user user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user=new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate"));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findByUsername(Connection con, String username) throws SQLException {
        String dbRequire="select * from usertable where username='"+username+"'";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findByPassword(Connection con, String password) throws SQLException {
        String dbRequire="select * from usertable where password='"+password+"'";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findByEmail(Connection con, String email) throws SQLException {
        String dbRequire="select * from usertable where mail='"+email+"'";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findByGender(Connection con, String gender) throws SQLException {
        String dbRequire="select * from usertable where gender='"+gender+"'";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String dbRequire="select * from usertable where birthDate='"+birthDate+"'";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public List<user> findAllUser(Connection con) throws SQLException {
        String dbRequire="select * from usertable ";
        List<user> user=null;
        try{
            PreparedStatement st=con.prepareStatement(dbRequire);
            ResultSet resultDb=st.executeQuery();
            if(resultDb.next()) {
                user.add(new user(resultDb.getInt("id"),resultDb.getString("username"),
                        resultDb.getString("password"),resultDb.getString("email"),
                        resultDb.getString("gender"),resultDb.getDate("birthDate")));
            }
        }catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }
}
