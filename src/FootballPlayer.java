import java.io.Serializable;

/**
 * Created by Dasuni on 11/2/2014.
 */
public class FootballPlayer implements Serializable {

    private String fName;
    private String lName;
    private String club;
    private int noOfGoals;

    public FootballPlayer(String fName, String lName, String club, int noOfGoals) {
        this.fName = fName;
        this.lName = lName;
        this.club = club;
        this.noOfGoals = noOfGoals;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public int getNoOfGoals() {
        return noOfGoals;
    }

    public void setNoOfGoals(int noOfGoals) {
        this.noOfGoals = noOfGoals;
    }







}
