import java.util.Scanner;

/**
 * Created by Dasuni on 11/2/2014.
 */
public class Utils {

	//To get the user's input.
	static Scanner sc = new Scanner(System.in);

	//To store the input value in a string.
	public static String scannerUserInput() {

		String userInput = sc.nextLine();

		//This will return the user input.
		return userInput;

	}

}
