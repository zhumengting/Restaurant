package com.food.dao;

import com.food.model.User;

public interface UserDao{  
	public  User login(String phoneNum,String pass);
	public  void register(String phoneNum,String pass,String name);
	public  void editPassword(String Id,String pass);
	public  String selectImg(String Id);
	public  boolean IsExist(String phoneNum);
	public  String encrypt(String key);
	public  User getUserById(String id);
	public  void updateUser(String condition, String data,String id);
	public int GetUserListNumber();
}  
