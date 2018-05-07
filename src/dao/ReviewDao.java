package com.food.dao;

import java.util.List;
import com.food.view.ReviewItem;
import com.food.view.ReviewOverview;

public interface ReviewDao {
	public List<ReviewItem> getSingleBusinessReviewList(String businessId);
	public ReviewOverview getSingleBusinessReviewOverview(String businessId);
}
