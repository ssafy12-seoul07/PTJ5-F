package com.ssafy.review.model.repository;

import java.util.List;

import com.ssafy.review.model.dto.Review;

public interface ReviewRepository {
	public abstract List<Review> selectAllByVideoId(int VideoId);
	
	public abstract Review selectOne(int id);
	
	public abstract void insertReview(Review review);

	public abstract void updateReview(Review review);

	public abstract void deleteReview(int id);

}
