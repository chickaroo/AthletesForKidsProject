
package appdraft;

/**
 *
 * @author saman
 */
public class Meeting {
    private String date;
    private String hours;
    private String description;
    private int mentorID;
    
    
    public Meeting(String date, String hours, String description, int currID){
        this.date = date;
        this.hours = hours;
        this.description = description;
        this.mentorID = currID;
    }
    
    public String getDate(){
        return this.date;
    }
    
    public String getHours(){
        return this.hours;
    }
    
    public String getDescription(){
        return description;
    }
    
    public int getMentorID(){
        return mentorID;
    }
    
    
}
