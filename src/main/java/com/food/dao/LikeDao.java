package com.food.dao;

public interface LikeDao {
	
public void AddLikeRestaurant(String userid,String restaurantid);
public void DeleteLikeRestaurant(String userid,String restaurantid);

}
