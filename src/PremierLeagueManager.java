/**
 * Created by Dasuni on 11/2/2014.
 */
public class PremierLeagueManager implements LeagueManager {

	public void welcomeNote() {

		System.out.println();
		System.out.println();

		System.out.println(PremierLeagueConstant.WELCOME_NOTE);
		System.out.println();

	}

	public void userSelectionMenu() {

		System.out.println(PremierLeagueConstant.USER_SELECTION);

		System.out.println();
		//To get the users input.
		System.out.print("Enter your selection to continue : ");
		//To convert the string to integer.
		int userSelection = Integer.parseInt(Utils.scannerUserInput());

		System.out.println();
		System.out.println();

		if (userSelection > 6) {
			System.out.println("ERROR!! \n Invalid input!!");
		} else {
			DBAccess dbAccess = new DBAccess();
			switch (userSelection) {

				case 1:
					try {

						dbAccess.getFtClubObject();
					} catch (Exception e) {
						e.printStackTrace();
					}
					dbAccess.sortByPoints();
					userSelectionMenu();
					break;
				case 2:
					dbAccess.addClub();
					userSelectionMenu();
					break;
				case 3:
					dbAccess.deleteClub();
					userSelectionMenu();
					break;
				case 4:
					System.out.println("4");
					break;
				case 5:
					Calendar cal = new Calendar();
					cal.print();
					userSelectionMenu();
					System.out.println();
					break;
				case 6:
					System.out.println("6");
					break;
				case 0:
					System.exit(0);

			}
		}
	}

}
