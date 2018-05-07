package com.food.service;

import java.util.ArrayList;
import java.util.List;

import com.food.dao.BusinessDao;
import com.food.daoImp.BusinessDaoImp;
import com.food.model.Business;
import com.food.view.BItem;

public class SearchService {
	
	public void search() {

		BusinessDao busiDao = new BusinessDaoImp();

		List<String> searchConditions = new ArrayList<String>();
		searchConditions.add("pizza");
		List<BItem> itemlist = busiDao.QueryBusiness(searchConditions);

	}
	
}
