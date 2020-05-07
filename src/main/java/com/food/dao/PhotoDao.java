package com.food.dao;

import java.util.List;

import com.food.model.Business;
import com.food.model.Photo;

public interface PhotoDao {
public List<Photo>getPicbyBusiness(List<Business>businesses);
}
