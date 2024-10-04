package com.ssafy.video.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.util.DBUtil;
import com.ssafy.video.model.dto.Video;

public class VideoDaoImpl implements VideoDao {
	
	private static VideoDao repo = new VideoDaoImpl();
	
	private VideoDaoImpl() {
		
	}
	
	public static VideoDao getInstance() {
		return repo;
	}
	
	public List<Video> selectAll() {
		String sql = "SELECT * FROM Video";
		List<Video> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Video video= new Video();
                video.setId(rs.getInt("video_id"));
                video.setTitle(rs.getString("video_title"));
                video.setChannelName(rs.getString("video_channel_name"));
                video.setPart(rs.getString("video_part"));
                video.setUrl(rs.getString("video_url"));
                result.add(video);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }
        
		return result;
	}

	public Video selectOne(int id) {
		String sql = "SELECT * FROM Video WHERE video_id=?";
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Video video = null;
        try {
            conn = DBUtil.getInstance().getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                video = new Video();
                video.setId(rs.getInt("video_id"));
                video.setTitle(rs.getString("video_title"));
                video.setChannelName(rs.getString("video_channel_name"));
                video.setPart(rs.getString("video_part"));
                video.setUrl(rs.getString("video_url"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, pstmt, rs);
        }

        return video;
	}

	@Override
	public void insertVideo(Video video) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateVideo(Video video) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteVideo(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateViewCnt(int id) {
		// TODO Auto-generated method stub

	}

}
