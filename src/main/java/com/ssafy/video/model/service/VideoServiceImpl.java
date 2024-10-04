package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dao.VideoDao;
import com.ssafy.video.model.dao.VideoDaoImpl;
import com.ssafy.video.model.dto.Video;

public class VideoServiceImpl implements VideoService {

	private static VideoService service = new VideoServiceImpl();
	private VideoDao dao = VideoDaoImpl.getInstance();
	
	private VideoServiceImpl() {
	}	
	
	public static VideoService getInstance() {
		return service;
	}
	
	@Override
	public List<Video> getList() {
		return dao.selectAll();
	}

	@Override
	public Video getVideo(int id) {
		return dao.selectOne(id);
	}

}
