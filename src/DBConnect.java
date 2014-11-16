import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Dasuni on 11/2/2014.
 */
public class DBConnect {

	private DBConnect(Connection connection) {
		this.connection = connection;
	}

	/**
	 *
	 */
	private DBConnect() {
	}

	public Connection connection = null;

	public static Connection getConnection() {
		// System.out.println("Getting Connection");
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// System.out.println("Where is MySQL Driver?");
			e.printStackTrace();
		}
		// System.out.println("MySQL Driver connected successfully");
		Connection connection = null;
		try {
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost/coursework", "root", "root");
		} catch (SQLException e) {
			//   System.out.println("Connection Failed. Check Output Console");
			e.printStackTrace();
		}
		if (connection != null) {
			//   System.out.println("You can now control your database");
		} else {
			//   System.out.println("Failed to make connection");
		}
		return connection;
	}

}
