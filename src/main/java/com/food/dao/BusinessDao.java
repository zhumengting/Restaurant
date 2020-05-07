package com.food.dao;


import java.util.List;
import java.util.Map;

import com.food.util.DbUtil;
import com.food.model.Business;
import com.food.view.BItem;

public interface BusinessDao {
	DbUtil dbUtil=new DbUtil();
	public List<Business> getAllFiveStarsBusiness();	
	public List<BItem> getTopRewBusiness();
	public List<BItem> getRecommendBusiness(int start,int end);//Ê×Ò³Î´µÇÂ½µÄÍÆ¼ö
	public List<BItem> getRecommendBusinessBaseOnUser(String userid,int start,int end);
	public List<BItem> getHighScoreBusinessList(int start,int end);
	public List<BItem> getHottestBusinessList(int start,int end);
	public List<BItem> getBusinessListbyIdList(List<String>ids);
	public  BItem getBusinessById(String id);
	public List<BItem> getBusinessListOfSingleCity(String cityName,int start,int end);
	public List<BItem> getBusinessListOfSingleCountry(String countryName,int start,int end);
	public BItem getSingleBusinessById(String id);
	
	public List<BItem> getChoosenBusinessList(String choosenCategorie,int start,int end);//type
	public List<BItem> getBusinessEnvironment(String choosenCategorie,int start,int end);
	
	
	public List<BItem> QueryBusiness(List<String> conditions,int start,int end);
	public Map<String,Map<String, String>> getOpenTimeOfSingleBusiness(String openHour);
	public String getUserFakeId(String trueid);
	public int cityBusinessCount(String cityName);
	public int categoriesBusinessCount(String categories);
	public int searchBusinessCount(String search);
	public int getAllNumber();
	public int EnvBusinessCount(String categories);
	public Map<Integer, String> GetAllBusinessIDsMap();
	public List<String> autoComplementSearch(String keyword);

}
