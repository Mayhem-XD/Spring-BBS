package com.ys.sbbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.ys.sbbs.entity.Board;
import com.ys.sbbs.entity.Reply;
import com.ys.sbbs.entity.User;

public class OracleTestSelectBoard {

	public static void main(String[] args) throws Exception {
		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521/XEPDB1";
		String username = "ysuser";
		String password = "yspass";
		
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url, username, password);
		String sql = "SELECT b.bid, b.\"uid\", b.title, b.content, b.modTime, b.viewCount,"
				+ " b.replyCount, b.files, u.uname FROM board  b JOIN users  u ON b.\"uid\"=u.\"uid\" WHERE b.bid=1001";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		Board board = new Board();
		while(rs.next()) {
			board.setBid(rs.getInt(1));
			board.setUid(rs.getString(2));
			board.setTitle(rs.getString(3));
			board.setContent(rs.getString(4));
			// 2023-07-19 10:40:55 ==> 2023-07-19T10:40:55
			board.setModTime(LocalDateTime.parse(rs.getString(5).replace(" ", "T")));
			board.setViewCount(rs.getInt(6));
			board.setReplyCount(rs.getInt(7));
			board.setFiles(rs.getString(8));
			board.setUname(rs.getString(9));
		}
		rs.close(); pstmt.close(); conn.close();
		System.out.println(board);
		
		conn = DriverManager.getConnection(url, username, password);
		List<Reply> replyList = new ArrayList<>();
		sql = "SELECT r.rid, r.\"comment\", r.regTime, r.isMine, r.\"uid\", r.bid, u.uname"
				+ " FROM reply r JOIN users u ON r.\"uid\"=u.\"uid\" WHERE bid=1001";
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			Reply r = new Reply(rs.getInt(1),rs.getString(2),
					LocalDateTime.parse(rs.getString(3).substring(0, 19).replace(" ", "T")),
					rs.getInt(4),rs.getString(5),rs.getInt(6),rs.getString(7));
			replyList.add(r);
		}
		rs.close(); pstmt.close(); conn.close();
		System.out.println(replyList);
	}
	

}
