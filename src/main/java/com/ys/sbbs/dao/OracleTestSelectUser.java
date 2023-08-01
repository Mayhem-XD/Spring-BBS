package com.ys.sbbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.ys.sbbs.entity.User;

public class OracleTestSelectUser {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "ysuser";
		String password = "yspass";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "select * from users";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<User> list = new ArrayList<>();
		while(rs.next()) {
			User user = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
					LocalDate.parse(rs.getString(5).substring(0,10)), rs.getInt(6), rs.getString(7), rs.getString(8));
			list.add(user);
		}
		rs.close(); pstmt.close(); conn.close();
		System.out.println(list);

	}

}
