package com.food.dao;

import com.food.model.User;

public interface UserDao{  
	public  User login(String phoneNum,String pass);
	public  void register(String phoneNum,String pass,String name);
	 public  boolean IsExist(String phoneNum);
	 public String encrypt(String key);
}  
