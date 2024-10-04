package com.ssafy.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ssafy.user.model.dto.User;
import com.ssafy.util.DBUtil;

public class UserDaoImpl implements UserDao {

	private static UserDaoImpl instance = new UserDaoImpl();

	private static DBUtil util = DBUtil.getInstance();

	public static UserDao getInstance() {
		return instance;
	}
	@Override
	public int insert(User user) {
		String sql = "INSERT INTO User (user_id, user_nickname, user_password) VALUES (?,?,?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getNickname());
			pstmt.setString(3, user.getPassword());
			result = pstmt.executeUpdate();
			System.out.println("추가 성공? : " + result);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		return result;
	}
	@Override
	public User selectOne(String id) {
		String sql = "SELECT * FROM User WHERE user_id=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				User user = new User();
				user.setId(rs.getString("user_id"));
				user.setNickname(rs.getString("user_nickname"));
				user.setPassword(rs.getString("user_password"));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		finally {
			util.close(conn, pstmt, rs);
		}
		return null;

	}

}
