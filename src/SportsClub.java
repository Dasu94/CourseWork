import java.io.Serializable;

/**
 * Created by Dasuni on 11/2/2014.
 */
public abstract class SportsClub implements Serializable {

	private String clubName;
	private String location;
	private int noOfWins;
	private int noOfDefeats;
	private int noOfDraws;
	private int noOfMatches;

	protected SportsClub(String clubName, String location, int noOfWins, int noOfDefeats,
	                     int noOfDraws, int noOfMatches) {
		this.clubName = clubName;
		this.location = location;
		this.noOfWins = noOfWins;
		this.noOfDefeats = noOfDefeats;
		this.noOfDraws = noOfDraws;
		this.noOfMatches = noOfMatches;
	}

	public SportsClub() {

	}

	public String getClubName() {
		return clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNoOfWins() {
		return noOfWins;
	}

	public void setNoOfWins(int noOfWins) {
		this.noOfWins = noOfWins;
	}

	public int getNoOfDefeats() {
		return noOfDefeats;
	}

	public void setNoOfDefeats(int noOfDefeats) {
		this.noOfDefeats = noOfDefeats;
	}

	public int getNoOfDraws() {
		return noOfDraws;
	}

	public void setNoOfDraws(int noOfDraws) {
		this.noOfDraws = noOfDraws;
	}

	public int getNoOfMatches() {
		return noOfMatches;
	}

	public void setNoOfMatches(int noOfMatches) {
		this.noOfMatches = noOfMatches;
	}
}
