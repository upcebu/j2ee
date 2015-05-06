/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DCS
 */
public class UserOptions {
    public List getOptions(String user){
        List l = new ArrayList();
        if(user.equals("admin")){
            l.add("Add");
            l.add("Remove");
            l.add("Edit");
            l.add("View");
        }else if (user.equals("user")){
            l.add("View");
        }
        return l;
    }
}
