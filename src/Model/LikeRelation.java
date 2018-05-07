package com.food.model;

public class LikeRelation {

	// Type of this operation, Like, Dislike or Star.
	private int lrType;
	// ID of user who do this operation.
	private int lrUserID;
	// ID of comment that operates on.
	private int lrCommentID;
	
	
	// Getters and setters.
	
	public int getLrType() {
		return lrType;
	}
	public void setLrType(int lrType) {
		this.lrType = lrType;
	}
	
	public int getLrUserID() {
		return lrUserID;
	}
	public void setLrUserID(int lrUserID) {
		this.lrUserID = lrUserID;
	}
	
	public int getLrCommentID() {
		return lrCommentID;
	}
	public void setLrCommentID(int lrCommentID) {
		this.lrCommentID = lrCommentID;
	}
	
}
