/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.servlets.example;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author DCS
 * Exercise 6: This will get values from checkboxes and radio buttons.
 */
public class HelloWorldServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String name = req.getParameter("name");
        String course = req.getParameter("course");
        String[] lang = req.getParameterValues("lang");
        String winner = req.getParameter("boxing");
        
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello "+name+"!</h1>");
        out.println("<h2>Are you sure you want to graduate "+course+"?</h2>");
        
        out.println("You must learn the following languages:");
        for(String a:lang){
            out.println(a+" ");
        }
        
        if(winner.equals("mayweather")){
            out.println("Winner");
        }else{
            out.println("Loser");
        }
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        doGet(req, res);
    }
    public void destroy(){
        
    }
}
