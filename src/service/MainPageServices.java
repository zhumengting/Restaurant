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
	OtherFunction fun=new OtherFunction();
	BusinessDao businessdao=new BusinessDaoImp();
	PhotoDao photodao=new PhotoDaoImp();
	public List<Photo>getBottomPic(){
		List<Photo> photos=new ArrayList<Photo>();
		List<Business>allFiveBusiness=businessdao.getAllFiveStarsBusiness();
		int number=allFiveBusiness.size();
		int[] result=new int[10];
		fun.generateRondomNumber(result, number-1);
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
	public static void main(String[] args) {
		MainPageServices ser=new MainPageServices();
		List<Photo> photos=ser.getBottomPic();
		
	}
}
