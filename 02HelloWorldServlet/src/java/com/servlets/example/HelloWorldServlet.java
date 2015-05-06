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
 * Exercise 3: This example creates an HTTP response printing simple HTML statement.
 */
public class HelloWorldServlet extends HttpServlet{
    public void init() throws ServletException{
        
    }
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        PrintWriter out = res.getWriter();
        out.println("<h1>Hello World!</h1>");
    }
    public void destroy(){
        
    }
}
