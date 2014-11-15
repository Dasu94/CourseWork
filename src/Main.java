/**
 * Created by Dasuni on 11/13/2014.
 */
public class Main {

    public static void main(String[] args) {
//        PremierLeagueManager print = new PremierLeagueManager();
//        print.welcomeNote();
//        print.userSelectionMenu();

        FootballPlayer mc = new FootballPlayer("das","dd","ss",7);



        DBAccess so = new DBAccess();

        try{
            so.setJavaObject(mc);
            so.saveFootballPlayer();
            System.out.println("saved");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try{
            so.getFtPlayerObject();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }


}
