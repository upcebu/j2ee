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
 */
public class DbUtil {
    private  Connection connection = null;
    
    public  Connection getConnection(){
        if(connection != null){
            return connection;
        }else{
            try{
                Properties prop = new Properties();
                InputStream inputStream = 
                        DbUtil.class.getClassLoader().getResourceAsStream("/db.properties");
                prop.load(inputStream);
                
                String driver = prop.getProperty("driver");
                String url = prop.getProperty("url");
                String user = prop.getProperty("user");
                String pass = prop.getProperty("password");
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, pass);
            }catch(ClassNotFoundException e){
                System.out.println("CLASS NOT FOUND");
                e.printStackTrace();
            }catch(SQLException e){
                System.out.println("SQL EXCEPTION");
                e.printStackTrace();
            }
            catch(FileNotFoundException e){
                System.out.println("FILE NOT FOUND");
                e.printStackTrace();
            }catch(IOException e){
                System.out.println("IOEXCEPTION");
                e.printStackTrace();
            }catch(Exception e){
                System.out.println("GENERIC EXCEPTION");
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
