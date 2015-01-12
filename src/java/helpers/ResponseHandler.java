package helpers;

import java.io.*;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ResponseHandler {
    
    
    //
    //
    //  Properties
    //
    //
    
    
    private ServletContext application;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    
    //
    //
    //  Private Methods
    //
    //
    
    
    private String _read (String filePath) {
        try {
            File f = new File(
                this.application.getRealPath("/") +
                "static/" +
                filePath
            );
            return new Scanner(f).useDelimiter("\\Z").next();
        } catch(Exception e) {
            this._internalServerError();
            return null;
        }
    }
    
    private boolean _write (String text) {
        try {
            this.response.getWriter().write(text);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    private void _redirect (String filePath) {
        try {
            this.response.sendRedirect(filePath);
        } catch (IOException e) {
            this._internalServerError();
        }
    }
    
    private void _reply (String text, int statusCode) {
        this._status(statusCode);
        this._write(text);
    }
    
    private void _internalServerError () {
        this._status(500);
        this._write("Internal Server Error");
    }

    private void _status (int statusCode) {
        this.response.setStatus(statusCode);
    }
    
    
    //
    //
    //  Constructor
    //
    //
    
    
    public ResponseHandler (HttpServletResponse response,
            HttpServletRequest request,
            ServletContext application) {
        
        this.request = request;
        this.response = response;
        this.application = application;
    }
    
    
    //
    //
    //  Public Methods
    //
    //
    
    
    public void redirect (String filePath) {
        this._redirect(filePath);
    }
    
    public void error (String text) {
        this._reply(text, 400);
    }
    
    public void success (String text) {
        this._reply(text, 200);
    }
    
    public void reply (String text, int statusCode) {
        this._reply(text, statusCode);
    }
    
    public void render (String filePath) {
        this._status(200);
        this._write(this._read(filePath));
    }
    
    public boolean isLoggedIn () {
        Auth auth = new Auth();
        return auth.isLoggedIn(this.request);
    }
    
    public boolean logIn () {
        Auth auth = new Auth();
        return auth.logIn(this.request);
    }
}
