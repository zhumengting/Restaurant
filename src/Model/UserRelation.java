package com.food.model;

public class UserRelation {

	// ID of user who is followed.
	private int urUserID;
	// ID of user who follows the other one.
	private int urFollowerID;
	
	
	// Getters and setters. 
	
	public int getUrUserID() {
		return urUserID;
	}
	public void setUrUserID(int urUserID) {
		this.urUserID = urUserID;
	}
	
	public int getUrFollowerID() {
		return urFollowerID;
	}
	public void setUrFollowerID(int urFollowerID) {
		this.urFollowerID = urFollowerID;
	}
	
	
}
