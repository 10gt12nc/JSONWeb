package tw.lin.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnectionUtils {
	private Connection conn;

	private DBConnectionUtils() {
		try {
			String DRIVER = "com.mysql.cj.jdbc.Driver";
			String URI = "jdbc:mysql:///jsonmsg?&serverTimezone=GMT";
			String USER = "root";
			String PASS = "123456";
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URI, USER, PASS);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return conn;
	}

	public static DBConnectionUtils getDB() {
		return new DBConnectionUtils();

	}

	public void close(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(PreparedStatement ps) {
		try {
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(Statement st) {
		try {
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
