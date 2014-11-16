import java.util.ArrayList;

/**
 * Created by Dasuni on 11/13/2014.
 */
public class Main {



	public static void main(String[] args) {

        //To get the default clubs
		DBAccess dbAccess = new DBAccess();

		try {
			dbAccess.defaultClubs();
			dbAccess.getFtClubObject();
		} catch (Exception e) {
			e.printStackTrace();
		}

		PremierLeagueManager print = new PremierLeagueManager();
		print.welcomeNote();
		print.userSelectionMenu();

	}

}
