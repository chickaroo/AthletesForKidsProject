/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdraft;

/**
 *
 * @author saman
 */
public class currentMentor {
    
    private String username;
    private String password;
    
    public currentMentor(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public String getUsername(){
        return this.username;
    }
    
    public String getPassword(){
        return this.password;
    }
    
    public void setUsernameNull(){
        this.username = null;
    }
    
    public void setPasswordNull(){
        this.password = null;
    }
    
}
