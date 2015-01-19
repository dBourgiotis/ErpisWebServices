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



import java.text.SimpleDateFormat;

import java.util.Date;
import javax.jws.WebService;

import javax.validation.constraints.*;

@WebService
public class User {
    
    @NotNull

        private String uname;

        private String password;

        private String role;

        private int id;

    public void setId(int id) {
        this.id = id;
    }

        /**

         * @return the uname

         */

        public String getUname() {

            return uname;

        }

        /**

         * @param uname the uname to set

         */

        public void setUname(String uname) {

            this.uname = uname;

        }

   

   

        /**

         * @return the password

         */

        public String getPassword() {

            return password;

        }

        /**

         * @param password the password to set

         */

        public void setPassword(String password) {

            this.password = password;

        }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getId() {
        return id;
    }

        
    
}
