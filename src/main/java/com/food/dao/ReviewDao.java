package com.food.dao;

import java.util.List;

import com.food.model.Review;
import com.food.view.ReviewItem;
import com.food.view.ReviewOverview;

public interface ReviewDao {
	public List<ReviewItem> getSingleBusinessReviewList(String businessId,int start,int selectCounts);
	public ReviewOverview getSingleBusinessReviewOverview(String businessId);
	public int singleBusinessReviewCount(String businessId);
	public int singleUserReviewCount(String userid);
	public List<String> getSingleUserReviewList(String userid);
	public boolean addNewReview(String businessId,String userid,String review_content,int stars);
	public List<Review> getReviewListByUserId(String Uid);
}
