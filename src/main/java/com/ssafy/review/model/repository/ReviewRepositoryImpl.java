package com.ssafy.review.model.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.review.model.dto.Review;

//싱글턴
public class ReviewRepositoryImpl implements ReviewRepository {

	private static ReviewRepository repo = new ReviewRepositoryImpl();

	private List<Review> list = new ArrayList<>();
	private Map<Integer, Review> reviews = new HashMap<>();

	private ReviewRepositoryImpl() {
	}

	public static ReviewRepository getInstance() {
		return repo;
	}

	public List<Review> selectAllByVideoId(int videoId) {
		List<Review> tmp = new ArrayList<>();

		for (Review review : this.list) {
			if (review.getVideoId() == videoId) {
				tmp.add(review);
			}
		}

		return tmp;
	}

	public Review selectOne(int id) {
		return reviews.get(id);
	}

	public void insertReview(Review review) {
		reviews.put(review.getId(), review);

		list.add(review);
	}

	public void updateReview(Review review) {
		if (reviews.get(review.getId()) != null) {
			reviews.put(review.getId(), review);
		}

		int index = findIndexById(review.getId());
		if (index >= 0) {
			list.set(index, review);
		}
	}

	public void deleteReview(int id) {
		int index = findIndexById(id);
		if (index == -1) {
			return;
		}

		list.remove(index);
	}

	private int findIndexById(int id) {
		if (list.size() <= id) {
			for (int i = list.size() - 1; i >= 0; i--) {
				if (list.get(i).getId() == id) {
					return i;
				}
			}
		}

		int l = 0, r = list.size() - 1;
		while (l < r) {
			int mid = (l + r) / 2;

			int tmp = list.get(mid).getId();
			if (tmp == id) {
				return mid;
			}

			else if (tmp > id) {
				r = mid + 1;
			} else {
				l = mid;
			}
		}

		return -1;
	}
}
