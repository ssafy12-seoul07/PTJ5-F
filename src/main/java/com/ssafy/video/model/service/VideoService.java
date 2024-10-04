package com.ssafy.video.model.service;

import java.util.List;

import com.ssafy.video.model.dto.Video;

public interface VideoService {
		// 전체 비디오 조회
		public abstract List<Video> getList();
		
		// 한개 비디오 조회
		public abstract Video getVideo(int id);
}
