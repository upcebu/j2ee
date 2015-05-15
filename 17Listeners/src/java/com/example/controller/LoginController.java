/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.UserBean;
import com.example.util.DbUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author DCS
 * Exercise 17: Implement listeners on session lifecycle and events. Can be used to count total tries to login. 
 */
public class LoginController extends HttpServlet {
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            
            UserBean user = new UserBean();
            user.setPassword(password);
            user.setUsername(username);
            
            boolean isUserValid = UserDao.isValid(user);
            System.out.println("user:"+username);
            System.out.println("pass:"+password);
            System.out.println("valid:"+isUserValid);
            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            
            //For listeners
            String val = (String) session.getAttribute("counter");
            int counter = 1;
            if(val!=null){
                counter = Integer.parseInt(val);
                counter++;
            }
            
            session.setAttribute("counter", String.valueOf(counter));
            //end of listeners
            
            if(isUserValid){
                session.setAttribute("users", UserDao.getAllUsers());
                RequestDispatcher view = request.getRequestDispatcher("home.jsp");
                view.forward(request, response);
            }else{
                //RequestDispatcher view = request.getRequestDispatcher("index.html");
                //view.forward(request, response);
                response.sendRedirect("index.html");
                
            }
            
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
