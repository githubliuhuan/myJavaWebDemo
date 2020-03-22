package main.webapp.java;
import main.webapp.java.DBConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//  调用数据库，进行查询用户名和密码
public class LoginSuccess{
	public boolean LoginSuccess(String username, String password) throws Exception {
		boolean returnValue = false;
		String sql = "SELECT * FROM user";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DBConnection.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				String userName = rs.getString("username");
				String passWord = rs.getString("password");
				if (userName.equals(username) && passWord.equals(password)) {
					//   如果用户名和密码都和数据库的一样，就返回true
					returnValue = true;
					break;
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return returnValue;

	}
}

