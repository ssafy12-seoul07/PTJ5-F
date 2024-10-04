package com.ssafy.review.model.service;

import java.util.List;

import com.ssafy.review.model.dto.Review;

public interface ReviewService {
	public List<Review> getReviewListOfVideo(int videoId);
	
	public Review getReview(int id);
	
	public void writeReview(Review review);

	public void modifyReview(Review review);

	public void removeReview(int id);

	public void likeReview(int id);
	
	public void dislikeReview(int id);
}
