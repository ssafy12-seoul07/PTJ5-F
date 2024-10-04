package com.ssafy.review.model.repository;

import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ssafy.review.model.dto.Review;
import com.ssafy.util.DBUtil;

//싱글턴
public class ReviewDaoImpl implements ReviewDao {
	
	private DBUtil util = DBUtil.getInstance();

	private static ReviewDao repo = new ReviewDaoImpl();

//	private List<Review> list = new ArrayList<>();
	
//	private Map<Integer, Review> reviews = new HashMap<>();

	private ReviewDaoImpl() {
	}

	public static ReviewDao getInstance() {
		return repo;
	}

	public List<Review> selectAllByVideoId(int videoId) {
		List<Review> tmp = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM Review WHERE video_id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			System.out.println("before : " + pstmt);
			pstmt.setInt(1, videoId);
			rs = pstmt.executeQuery();
			System.out.println("after : " + pstmt);
			System.out.println(sql);
			
			while(rs.next()) {
				Review review = new Review();
				review.setVideoId(rs.getInt("video_id"));
				review.setTitle(rs.getString("review_title"));
				review.setWriter(rs.getString("user_id"));
				review.setContent(rs.getString("review_content"));
				tmp.add(review);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} finally {
			util.close(conn, pstmt, rs);
		}
		
		return tmp;
	}

	public Review selectOne(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM Review WHERE id=?";
		ResultSet rs = null;
		Review review = new Review();

		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				review.setVideoId(rs.getInt("video_id"));
				review.setTitle(rs.getString("review_title"));
				review.setWriter(rs.getString("review_writer"));
				review.setContent(rs.getString("review_content"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt, rs);
		}
		return review;
		
	}

	public void insertReview(Review review) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO Review (user_id, video_id, review_title, review_content) VALUES (?,?,?,?)";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getWriter());
			pstmt.setInt(2, review.getVideoId());
			pstmt.setString(3, review.getTitle());
			pstmt.setString(4, review.getContent());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
	}

	public void updateReview(Review review) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "UPDATE Review SET review_title=?, review_content=? WHERE review_id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, review.getTitle());
			pstmt.setString(2, review.getContent());
			pstmt.setInt(3, review.getId());
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
	}

	public void deleteReview(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM Review WHERE review_id=?";
		
		try {
			conn = util.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			util.close(conn, pstmt);
		}
		
	}
}
