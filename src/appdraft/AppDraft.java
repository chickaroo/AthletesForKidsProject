/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appdraft;
import java.sql.Connection;
import appdraft.SQLDatabase.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
/**
 *
 * @author saman
 */
public class AppDraft {

    
    
    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        AppDraftGUI jf = new AppDraftGUI();
        jf.setVisible(true);
        jf.setBounds(200, 200, 900, 600);
        
        
        
        //database.testDatabase(); //WORKS
        //System.out.println(database.checkUser("sbening", "sbening")); WORKS
        //database.tryQuery(); WORKS
        //System.out.println(database.getUsername("sbening", "sbening")); WORKS
        
        
        
        
    }
    
}
