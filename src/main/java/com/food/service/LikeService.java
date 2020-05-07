package com.food.service;

import com.food.dao.LikeDao;
import com.food.daoImp.LikeDaoImp;

public class LikeService {
	LikeDao likedao=new LikeDaoImp();
	public void AddLikeRestaurant(String userid, String restaurantid) {
		likedao.AddLikeRestaurant(userid, restaurantid);
	}
	public void DeleteLikeRestaurant(String userid, String restaurantid) {
		likedao.DeleteLikeRestaurant(userid, restaurantid);
	}
}
