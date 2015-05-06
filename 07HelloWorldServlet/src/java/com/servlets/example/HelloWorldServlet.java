/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DCS
 * Exercise 7: This is an exercise on forwarding request to another resource such as a servlet.
 */
public class HelloWorldServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        String type = req.getParameter("type");
        
       
        if(type.equals("admin")){
            RequestDispatcher rd = req.getRequestDispatcher("/ProcessAdminServlet");
            rd.forward(req, res);
        }else if(type.equals("user")){
            RequestDispatcher rd = req.getRequestDispatcher("/ProcessUserServlet");
            rd.forward(req, res);
        }
        
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
    public void destroy(){
        
    }
}
