/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.listener;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author DCS
 */
public class TimeOutListener implements HttpSessionListener{

    @Override
    public void sessionCreated(HttpSessionEvent hse) {
        System.out.println("TIMEOUT listener created.");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent hse) {
        HttpSession session = hse.getSession();
        long now = new java.util.Date().getTime();
        boolean timeout = (now-session.getLastAccessedTime()) >= ((long)session.getMaxInactiveInterval()*1000L);
        if(timeout){
            System.out.println("TIMEOUT DETECTED"+timeout);
        }
    }
    
}
