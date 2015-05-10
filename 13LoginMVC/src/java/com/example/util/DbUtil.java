/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.util;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DCS
 * Script in mysql terminal to grant username and password for db (admin, test).
 *   create database UserDB;
 *   use UserDB;
 *   grant all on UserDB.* to 'admin'@'localhost' identified by 'test'; 
 */
public class DbUtil {
    private  Connection connection = null;
    
    public  Connection getConnection(){
        if(connection != null){
            return connection;
        }else{
            try{
                String driver="com.mysql.jdbc.Driver";
                String url="jdbc:mysql://localhost:3306/userdb";
                Class.forName(driver);
                connection = DriverManager.getConnection(url, "admin", "test");
                
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
            return connection;
        }
    }
    public  boolean disconnect(){
       try{
           connection.close();
       }catch(SQLException se){
         //Handle errors for JDBC
         se.printStackTrace();
      }catch(Exception e){
         //Handle errors for Class.forName
         e.printStackTrace();
      }
       return true;
    }
    
}
