package com.food.dao;

import java.util.List;

import com.food.util.DbUtil;
import com.food.model.Business;
import com.food.view.BItem;

public interface BusinessDao {
	
	DbUtil dbUtil = new DbUtil();

	public List<Business> getAllFiveStarsBusiness();

	public List<BItem> getTopRewBusiness();

	public List<BItem> getHighScoreBusinessList(int rn);

	public List<Business> getHottestBusinessList();

	public BItem getBusinessById(String id);

	public List<BItem> getBusinessListOfSingleCity(String cityName);

	public List<BItem> getBusinessListOfSingleCountry(String countryName);

	public BItem getSingleBusinessById(String id);

	public List<BItem> getChoosenBusinessList(String choosenCategorie);

	public List<BItem> QueryBusiness(List<String> conditions);
}
