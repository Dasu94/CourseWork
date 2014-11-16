/**
 * Created by Dasuni on 11/3/2014.
 */

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBAccess {

	public Object javaObject = null;

	ArrayList<FootballClub> clubObjects = new ArrayList<FootballClub>();
	ArrayList<FootballPlayer> playerObjects = new ArrayList<FootballPlayer>();

	public Object getJavaObject() {
		return javaObject;
	}

	public void setJavaObject(Object javaObject) {
		this.javaObject = javaObject;
	}

	public void saveFootballClub() throws Exception {
		try {
			Connection connec = DBConnect.getConnection();
			PreparedStatement ps = null;
			String sql = null;

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(javaObject);
			oos.flush();
			oos.close();
			bos.close();

			byte[] data = bos.toByteArray();

			sql = "INSERT INTO footballclub (clubobj) VALUES(?)";
			ps = connec.prepareStatement(sql);
			ps.setObject(1, data);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object getFtClubObject() throws Exception {
		Object rmObj = null;
		Connection connec = DBConnect.getConnection();
		PreparedStatement ps = null;

		ResultSet rs = null;
		String sql = null;

		sql = "SELECT clubobj FROM footballclub";

		ps = connec.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			ByteArrayInputStream bais;
			ObjectInputStream ins;

			try {

				bais = new ByteArrayInputStream(rs.getBytes("clubobj"));
				ins = new ObjectInputStream(bais);

				FootballClub mc = (FootballClub) ins.readObject();
				clubObjects.add(mc);
				//System.out.println("Object in value :" + mc.getClubName());
				ins.close();

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return rmObj;
	}

	public void saveFootballPlayer() throws Exception {
		try {
			Connection connec = DBConnect.getConnection();
			PreparedStatement ps = null;
			String sql = null;

			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);

			oos.writeObject(javaObject);
			oos.flush();
			oos.close();
			bos.close();

			byte[] data = bos.toByteArray();

			sql = "INSERT INTO footballplayer  VALUES(?)";
			ps = connec.prepareStatement(sql);
			ps.setObject(1, data);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public Object getFtPlayerObject() throws Exception {
		Object rmObj = null;
		Connection connec = DBConnect.getConnection();
		PreparedStatement ps = null;

		ResultSet rs = null;
		String sql = null;

		sql = "SELECT * FROM footballplayer";

		ps = connec.prepareStatement(sql);
		rs = ps.executeQuery();

		while (rs.next()) {
			ByteArrayInputStream bais;
			ObjectInputStream ins;

			try {

				bais = new ByteArrayInputStream(rs.getBytes("playerobj"));
				ins = new ObjectInputStream(bais);

				FootballPlayer player = (FootballPlayer) ins.readObject();
				playerObjects.add(player);
				System.out.println("Object in value :" + player.getfName());
				ins.close();

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

		return rmObj;
	}

	public void defaultClubs() {

		DBAccess so = new DBAccess();

		try {
			so.setJavaObject(new FootballClub("Chelsea", "London,England", 1, 2, 1, 4, 4, 6, 10));
			so.saveFootballClub();
			so.setJavaObject(
					new FootballClub("Manchester United", "Manchester,England", 1, 2, 2, 5, 4, 3,
					                 10));
			so.saveFootballClub();
			so.setJavaObject(
					new FootballClub("West Ham United", "London,England", 2, 1, 0, 3, 4, 6, 15));
			so.saveFootballClub();
			so.setJavaObject(
					new FootballClub("Southampton", "Southampton,England", 1, 2, 2, 5, 4, 3, 4));
			so.setJavaObject(
					new FootballClub("Swansea City", "Swansea,Wales", 1, 2, 2, 5, 4, 3, 4));
			so.setJavaObject(new FootballClub("Arsenal", "Halloway,England", 1, 2, 2, 5, 4, 3, 4));
			so.setJavaObject(
					new FootballClub("Liverpool", "Liverpool,England", 1, 2, 2, 5, 4, 3, 4));
			so.setJavaObject(
					new FootballClub("Sunderland", "Sunderland,England", 1, 2, 2, 5, 4, 3, 4));
			so.setJavaObject(
					new FootballClub("Newcastle United", "Newcastle,England", 1, 2, 2, 5, 4, 3,
					                 4));
			so.setJavaObject(
					new FootballClub("Manchester City", "Manchester,England", 1, 2, 2, 5, 4, 3,
					                 4));
			so.setJavaObject(new FootballClub("Everton", "Liverpool,England", 1, 2, 2, 5, 4, 3,
			                                  4));
			so.setJavaObject(
					new FootballClub("Queens Park Rangers", "London,England", 1, 2, 2, 5, 4, 3,
					                 4));

			System.out.println("saved");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void printPremierLeagueTable() {

		if (clubObjects.size() != 0) {
			System.out.println();
			System.out
					.println(PremierLeagueConstant.LEAGUE_TABLE);
			System.out.println();
			System.out.printf("%2s  %25s   %8s   %6s   %6s   %6s   %5s   %6s   %6s   %6s%n", "n",
			                  " Club",
			                  "played", "wins", "Draws", "Defeats", "G rec", "G scored", "G dif",
			                  "Points");

			System.out
					.println(
							"--------------------------------------------------------------------" +
							"------------------------------------");

			for (int j = 0; j < clubObjects.size(); j++) {
				System.out.printf("%2s  %25s   %6s   %6s   %6s   %6s   %6s   %6s   %6s   %6s%n",
				                  j + 1,
				                  clubObjects.get(j).getClubName(),
				                  clubObjects.get(j).getNoOfMatches(),
				                  clubObjects.get(j).getNoOfWins(),
				                  clubObjects.get(j).getNoOfDraws(),
				                  clubObjects.get(j).getNoOfDefeats(),
				                  clubObjects.get(j).getNoOfGoalsRecieved()
						, clubObjects.get(j).getNoOfGoalsScored(),
				                  clubObjects.get(j).goalDifference(
						                  clubObjects
								                  .get(j)
								                  .getNoOfGoalsRecieved(),

						                  clubObjects
								                  .get(j)
								                  .getNoOfGoalsScored()),

				                  clubObjects.get(j).getNoOfPoints());

			}
			System.out
					.println(
							"-----------------------------------------------------------------" +
							"---------------------------------------");
			System.out.println();
		} else {
			System.out.println(" No clubs currently in the league table !! ");
		}

	}

	public void sortByPoints() {

		FootballClub temp = new FootballClub();

		for (int i = 0; i < clubObjects.size(); i++) {

			int max = clubObjects.get(i).getNoOfPoints();
			int maxIndex = i;

			for (int j = i; j < clubObjects.size(); j++) {

				if (max < clubObjects.get(j).getNoOfPoints()) {
					max = clubObjects.get(j).getNoOfPoints();
					maxIndex = j;
				}
				if (max == clubObjects.get(j).getNoOfPoints()) {
					if (clubObjects.get(i).goalDifference(clubObjects.get(i)
					                                                 .getNoOfGoalsRecieved(),
					                                      clubObjects.get(i).getNoOfGoalsScored
							                                      ()) <
					    clubObjects.get(j).goalDifference(clubObjects.get(j)
					                                                 .getNoOfGoalsRecieved(),
					                                      clubObjects.get(j)
					                                                 .getNoOfGoalsScored())) {
						max = clubObjects.get(j).getNoOfPoints();
						maxIndex = j;
					}
				}
			}

			temp = clubObjects.get(i);
			clubObjects.set(i, clubObjects.get(maxIndex));
			clubObjects.set(maxIndex, temp);

		}
		//to print the league table.
		printPremierLeagueTable();

	}

	public void addClub() {

		System.out.println(PremierLeagueConstant.HEADING);
		System.out.println(PremierLeagueConstant.ADD_CLUB);
		System.out.println();

		// Prompts for clubs' details and store the details.

		try {
			DBAccess dbAccess = new DBAccess();
			FootballClub ft1 = new FootballClub();
			System.out.print("To add a new club : \nInput clubs' Name : ");
			ft1.setClubName(Utils.scannerUserInput());
			System.out.print("Location :");
			ft1.setLocation(Utils.scannerUserInput());
			dbAccess.setJavaObject(ft1);
			dbAccess.saveFootballClub();

			System.out.println(" Successfully added to the premier league !! ");
			System.out.println();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	public void delete(int clubId){

		PreparedStatement ps = null;
		Connection connection = DBConnect.getConnection();
		String sql = "DELETE FROM footballclub WHERE clubId ='"+clubId+"'";
		try {
			ps = connection.prepareStatement(sql);
			ps.executeUpdate();
			System.out.println("hari");


		} catch (Exception e) {
			e.printStackTrace();
		}



	}

	public void deleteClub(){

		printPremierLeagueTable();
		
		System.out.print("To add a new club : \nInput clubs' Name : ");
		int clubId = Integer.parseInt(Utils.scannerUserInput());
		delete(clubId);
	}

}





