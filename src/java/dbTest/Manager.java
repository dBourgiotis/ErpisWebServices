/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.List;
/**
 *
 * @author it21221
 */
public class Manager {
    
    private Connection connection;

         

    public Manager() {

            connection = Database.getConnection();

    }
            public boolean checkUser(String fname, String pasw) {

            try {

                PreparedStatement ps = connection.prepareStatement("select id from User where FullName = ? and Password = ?");

                ps.setString(1, fname);
                ps.setString(2, pasw);

                ResultSet rs = ps.executeQuery();

                if (rs.next()) // found

                {
                   connection.close();
                   System.out.println("Found");
                   return true;

                } else {
                   connection.close();
                   System.out.println("Not Found"); 
                   return false ; 

                }

            } catch (Exception ex) {

                System.out.println("Error in check() -->" + ex.getMessage());

            }
           
             System.out.println("Error yolo");
            return false;

        }    
        
    
}
