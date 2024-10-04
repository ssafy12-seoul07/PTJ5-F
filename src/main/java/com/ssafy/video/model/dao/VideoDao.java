package com.ssafy.video.model.dao;

import java.util.List;

import com.ssafy.video.model.dto.Video;

public interface VideoDao {

	//전체 게시글 가져오기
		public abstract List<Video> selectAll();

		//게시글 조회하기
		public abstract Video selectOne(int id);

		//게시글 등록하기
		public abstract void insertVideo(Video video);

		//게시글 수정하기
		public abstract void updateVideo(Video video);

		//게시글 삭제하기
		public abstract void deleteVideo(int id);

		//게시글 조회수 증가
		public abstract void updateViewCnt(int id);

}
