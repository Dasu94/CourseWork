/**
 * Created by Dasuni on 11/2/2014.
 */
public class Calendar {



    //to store months in the year
    String[] months = { "","January", "February", "March",
            "April", "May", "June",
            "July", "August", "September",
            "October", "November", "December"
    };


    int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };



    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        int d = (day + x + (31*m)/12) % 7;
        return d;
    }

    public void print(){

        System.out.print("\t Enter the year :");
        int year = Integer.parseInt(Utils.scannerUserInput());
        System.out.print("\t Enter the number of the month :");
        int month = Integer.parseInt(Utils.scannerUserInput());
        System.out.println();

        System.out.println(">>>>>>" + months[month] + " " + year+"<<<<<<");
        System.out.println(" S  M Tu  W Th  F  S");

        // to get the starting day
        int day = day(month,1,year);


        if (month == 2 && isLeapYear(year)){
            days[month] = 29;
        }

        // print the calendar
        for (int i = 0; i < day; i++)
            System.out.print("   ");
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ", i);
            if (((i + day) % 7 == 0) || (i == days[month])){
                System.out.println();
            }

        }

    }

    public  boolean isLeapYear(int year) {
        if((year % 4 == 0) && (year % 100 != 0)){
            return true;
        }
        if  (year % 400 == 0){
            return true;
        }
        return false;
    }




}
