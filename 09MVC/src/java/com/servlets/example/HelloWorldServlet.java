/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.example;

import com.example.model.UserOptions;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DCS
 * * Exercise 9: This is a simple MVC: 
 * Starting file: login
 * M: Contains the logic for the options, returns a list
 * V: Access the list of options in the JSP file
 * C: get the request param and call the model, sets the model list as attribute,
 *      dispatch to the view
 */
public class HelloWorldServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        
        String type = req.getParameter("type");
        
        List l = new UserOptions().getOptions(type);
        req.setAttribute("options", l);
        
            RequestDispatcher rd = req.getRequestDispatcher("home.jsp");
            rd.forward(req, res);
        
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
    public void destroy(){
        
    }
}
