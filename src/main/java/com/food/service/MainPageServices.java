package com.food.service;

import java.util.ArrayList;
import java.util.List;

import com.food.dao.*;
import com.food.daoImp.*;
import com.food.model.Business;
import com.food.model.*;
import com.food.util.DbUtil;
import com.food.util.OtherFunction;
import com.food.view.BItem;

public class MainPageServices {
	BusinessDao businessdao=new BusinessDaoImp();
	PhotoDao photodao=new PhotoDaoImp();
	public List<Photo>getBottomPic(){
		List<Photo> photos=new ArrayList<Photo>();
		List<Business>allFiveBusiness=businessdao.getAllFiveStarsBusiness();
		int number=allFiveBusiness.size();
		int[] result=new int[10];
		OtherFunction.generateRondomNumber(result, number-1);
		List<Business>rondomBusiness=new ArrayList<Business>();		
		for(int i=0;i<=9;i++) {
			rondomBusiness.add(allFiveBusiness.get(result[i]));
		}		
		photos=photodao.getPicbyBusiness(rondomBusiness);		
		return photos;
	}
	public List<BItem>getTop12(){
		return businessdao.getTopRewBusiness();
	}
	public List<BItem>getRecommend(){
		List<BItem> items=new ArrayList<BItem>();
		List<BItem> allitems=new ArrayList<BItem>();
		allitems=businessdao.getRecommendBusiness(1,50);
		for(int i=1;i<=6;i++) {
			items.add(allitems.get(i));
		}
		return items;
	}
	public static void main(String[] args) {

		
	}
}
