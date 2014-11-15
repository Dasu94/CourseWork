/**
 * Created by Dasuni on 11/2/2014.
 */
public class PremierLeagueManager implements LeagueManager {



    public void welcomeNote() {

        System.out.println();
        System.out.println();

        System.out
                .println("-----------------------------------------------WELCOME TO ENGLISH PREMIER LEAGUE MANAGER------------------------------------------------");
        System.out.println();

    }

    public void userSelectionMenu() {


        System.out
                .println("------------------------------------------------------------MAIN MENU------------------------------------------------------------------");
        System.out.println();

        System.out.println("\n Select any option below... \n");
        System.out.println("\t 1 - View Premier league table ");
        System.out.println("\t 2 - Add a new club to the league ");
        System.out.println("\t 3 - Delete a club from the league  ");
        System.out.println("\t 4 - View players' details  ");
        System.out.println("\t 5 - View Calendar ");
        System.out.println("\t 6 - Search match dates  ");
        System.out.println("\t 0 - EXIT  ");

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

            switch (userSelection) {

                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    System.out.println("3");
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

    public void defaultClubs(){


        DBAccess so = new DBAccess();

        try{
            so.setJavaObject(new FootballClub("Chelsea","London,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Manchester United","Manchester,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("West Ham United","London,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Southampton","Southampton,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Swansea City","Swansea,Wales",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Arsenal","Halloway,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Liverpool","Liverpool,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Sunderland","Sunderland,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Newcastle United","Newcastle,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Manchester City","Manchester,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Everton","Liverpool,England",1,2,2,5,4,3,4));
            so.setJavaObject(new FootballClub("Queens Park Rangers","London,England",1,2,2,5,4,3,4));
            so.saveFootballClub();
            System.out.println("saved");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        try{
            so.getFtClubObject();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }





}
