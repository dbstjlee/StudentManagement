package ver1;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DBConnetionManager {

	private static HikariDataSource dataSource;

	private static final String URL = "jdbc:mysql://localhost:3306/studentdb?serverTimezone=Asia/Seoul";
	private static final String USER = "root";
	private static final String PASSWORD = "asd123";

	static {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(URL);
		config.setUsername(USER);
		config.setPassword(PASSWORD);
		config.setMaximumPoolSize(10);

		dataSource = new HikariDataSource(config);

	}

	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection(); // Hikari....데이터 타입이 리턴됨.
	}

	// 테스트 코드 확인
	public static void main(String[] args) {

		// dataSource의 getConnection()을 conn에 담아야 함.
		try {
			Connection conn = DBConnetionManager.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
