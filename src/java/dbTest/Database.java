/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbTest;

/**
 *
 * @author it21221
 */
import java.sql.Connection;

import java.sql.DriverManager;
import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class Database {




   
     @WebMethod   
     public static Connection getConnection() {

          try  {

              Class.forName("com.mysql.jdbc.Driver");

              Connection con = DriverManager.getConnection("jdbc:mysql://62.217.125.30:3306/it21221","it21221","Harold");

              return con;

          }

          catch(Exception ex) {

              System.out.println("Database.getConnection() Error -->" + ex.getMessage());

              return null;

          }

      }

 
       @WebMethod  
       public static void close(Connection con) {

          try  {

              con.close();

          }

          catch(Exception ex) {

          }

      }

}
