/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.dao;

import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServlet;

/**
 *
 * @author DCS
 */
public class UserDao extends HttpServlet{
    
    
    
    public  static void addUser(UserBean user){
        DbUtil db = new DbUtil();
        try{
            PreparedStatement stmt = db.getConnection().prepareStatement("insert into users(username, password) values (?,?)");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            stmt.close();
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public  static void deleteUser(int userId){
        DbUtil db = new DbUtil();
        try{
            PreparedStatement stmt = db.getConnection().prepareStatement("delete from users where userid=?");
            stmt.setInt(1, userId);
            stmt.executeUpdate();
            stmt.close();
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public static void updateUser(UserBean user){
        DbUtil db = new DbUtil();
        try{
            PreparedStatement stmt = db.getConnection().prepareStatement("update users set username=?, password=? where userid=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getUserid());
            stmt.executeUpdate();
            stmt.close();
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static List<UserBean> getAllUsers(){
        List<UserBean> users = new ArrayList();
        DbUtil db = new DbUtil();
        try{
            Statement stmt =  db.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("select * from users");
            while(rs.next()){
                UserBean user = new UserBean();
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }
            rs.close();
            stmt.close();
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }
    
    public static UserBean getUserById(int userId){
        UserBean user = new UserBean();
        DbUtil db = new DbUtil();
        try{
            PreparedStatement stmt = db.getConnection().prepareStatement("select * from users where userid=?");
            stmt.setInt(1, userId);
            
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                user.setUserid(rs.getInt("userid"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            rs.close();
            stmt.close();
            db.disconnect();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }
    
    public  static boolean isValid(UserBean user){
        boolean result = false;
        DbUtil db = new DbUtil();
        System.out.println("dao:username"+user.getUsername());
        System.out.println("dao:pass"+user.getPassword());
        try{
            PreparedStatement stmt = db.getConnection().prepareStatement("select * from users where username=? and password=?");
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                result = true;
            }
            rs.close();
         stmt.close();
         db.disconnect();
        }catch(SQLException e){
            System.out.println("CONNECTION PROBLEM.");
            e.printStackTrace();
        }
        return result;
        
    }
    public static void main(String[] args) {
          UserBean user = new UserBean();
            user.setUserid(1);
            user.setUsername("user");
            user.setPassword("pass");
            
            System.out.println(UserDao.isValid(user)); 
            //UserDao.addUser(user);
            //UserDao.updateUser(user);
//            List<UserBean> list = UserDao.getAllUsers();
//            for(UserBean a:list)
//                System.out.println(a.getUsername());
            
            //System.out.println(UserDao.getUserById(1).getUsername());
            
    }
     
}
