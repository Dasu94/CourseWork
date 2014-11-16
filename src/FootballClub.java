import java.io.Serializable;

/**
 * Created by Dasuni on 11/2/2014.
 */
public class FootballClub extends SportsClub implements Serializable {

	private int noOfGoalsRecieved;
	private int noOfGoalsScored;
	private int noOfPoints;

	public FootballClub(String clubName, String location, int noOfWins, int noOfDefeats,
	                    int noOfDraws, int noOfMatches, int noOfGoalsRecieved, int noOfGoalsScored,
	                    int noOfPoints) {
		super(clubName, location, noOfWins, noOfDefeats, noOfDraws, noOfMatches);
		this.noOfGoalsRecieved = noOfGoalsRecieved;
		this.noOfGoalsScored = noOfGoalsScored;
		this.noOfPoints = noOfPoints;
	}

	public FootballClub() {

	}

	public int getNoOfPoints() {
		return noOfPoints;
	}

	public void setNoOfPoints(int noOfPoints) {
		this.noOfPoints = noOfPoints;
	}

	public int getNoOfGoalsRecieved() {
		return noOfGoalsRecieved;
	}

	public void setNoOfGoalsRecieved(int noOfGoalsRecieved) {
		this.noOfGoalsRecieved = noOfGoalsRecieved;
	}

	public int getNoOfGoalsScored() {
		return noOfGoalsScored;
	}

	public void setNoOfGoalsScored(int noOfGoalsScored) {
		this.noOfGoalsScored = noOfGoalsScored;
	}

	public int goalDifference(int noOfGoalsRecieved, int noOfGoalsScored) {
		int goalDifference = noOfGoalsScored - noOfGoalsRecieved;
		return goalDifference;

	}
}
