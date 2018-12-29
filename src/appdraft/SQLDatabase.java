/*


 */
package appdraft;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author saman
 */
public class SQLDatabase {
    private static SQLDatabase instance;
    private static Connection connect;
    private static Statement sqlState;
    private String marni = "mkurtz";
    
    private ArrayList<String> list = new ArrayList<String>();
    private String tempUser;
    private String tempPass;
    private String tempFName;
    private String tempLName;
    private String compiled;
    private int id;
    
    private ArrayList<String> event = new ArrayList<String>();
    private String tempDate;
    private String tempHours;
    private String tempDescription;
    private String compiledE;

    private SQLDatabase() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             connect = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/MentorList;user=sami;password=sami");
            sqlState = connect.createStatement();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(SQLDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static SQLDatabase getInstance(){
        if (instance == null){
            instance = new SQLDatabase();
        }
        return instance;
    }
    
    /*public void testDatabase() {
        
        try {
            ResultSet rs = sqlState.executeQuery("SELECT (FIRSTN) FROM SAMI.ALLMENTORS");
            while (rs.next()) {
                System.out.println(rs.getString("FIRSTN"));
            }
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }*/
    
    //checks who user is and returns 1 if its admin, 2 if its a mentor, and 3 if its neither
    public int checkUser(String user, String pass) {
        if (user.equals(marni)) {
            try {
                ResultSet rs=sqlState.executeQuery("SELECT * FROM SAMI.ALLMENTORS WHERE USERNAME = '"+marni+"' AND PASSWORD = '"+marni+"'");
                while (rs.next()) {
                    return 1; //1 = admin
                }
                connect.close();
                return 1; //3 = error
            } catch (SQLException e) {
                System.out.println(e);
                return 3; 
            }
        } else {
            try {
                ResultSet rs=sqlState.executeQuery("SELECT * FROM SAMI.ALLMENTORS WHERE USERNAME = '"+user+"' AND PASSWORD = '"+pass+"'");
                while (rs.next()) {
                    return 2; //2 = mentor
                }
                connect.close();
                return 2;
            } catch (SQLException e) {
                System.out.println(e);
                return 3;
            }
        }
    }

    public int getID(String username) {
        try {
            ResultSet rs = sqlState.executeQuery("SELECT ID FROM SAMI.ALLMENTORS WHERE USERNAME = '" + username + "'");
            while (rs.next()) {
                return rs.getInt("ID");
            }
            connect.close();
            return 1000; //1000 = error
        } catch (SQLException e) {
            System.out.println(e);
            return 1000; //1000 = error
        }
    }
    
    //use parameter (what mentor inputted) to set the date in table EVENTS as their input
    public void setInfo(String date, String hours, String description, int ID) {
        try {
            sqlState.executeUpdate("INSERT INTO EVENTS (DATE, HOURS, DESCRIPTION, PARENTID) VALUES ('"+date+"', '"+hours+"', '"+description+"', "+ID+")");
            connect.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    //returns ArrayList of individual mentors as strings
    public ArrayList<String> getMentorsList() {
        try {
            ResultSet rs = sqlState.executeQuery("SELECT * FROM SAMI.ALLMENTORS");
            while (rs.next()) {
                tempUser = rs.getString("USERNAME");
                tempPass = rs.getString("PASSWORD");
                tempFName = rs.getString("FIRSTN");
                tempLName = rs.getString("LASTN");
                id = rs.getInt("ID");
                compiled = ""+(id + 1)+" "+tempFName+" "+tempLName+", Username: "+tempUser+" , Password: "+tempPass+"";
                list.add(compiled);
                }
                return list;
            }
         catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }
    
    //returns an array list of the events of a specific mentor
    public ArrayList<String> getEventsList(int abc){
        try {
            ResultSet rs = sqlState.executeQuery("SELECT * FROM SAMI.EVENTS WHERE PARENTID = " + abc);
            while (rs.next()) {
                tempDate = rs.getString("DATE");
                tempHours = rs.getString("HOURS");
                tempDescription = rs.getString("DESCRIPTION");
                compiledE = ""+tempDate+": "+tempHours+" hours. Descpription: "+tempDescription+"";
                event.add(compiledE);
                }
                return event;
            }
         catch (SQLException e) {
            System.out.println(e);
            return null;
        }
    }

    
    
}
