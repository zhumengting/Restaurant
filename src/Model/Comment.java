package com.food.model;

public class Comment {

	// Comment id
	private int cID;
	// ID of user that make comment.
	private int cUserID;
	// ID of shop that comment to.
	private int cShopID;
	// Comment content
	private String cContent;
	// How much did user cost who consumed at the shop.
	private float cCost;
	// Shop taste score, 0.0 - 10.0
	private float cTasteScore;
	// Shop environment score, 0.0 - 10.0
	private float cEnvirScore;
	// Shop service score, 0.0 - 10.0
	private float cServiceScore;
	// Num of like to this comment.
	private int cLikeNum;
	// Num of dislike to this comment.
	private int cDislikeNum;
	// Num of star to this comment.
	private int cStarNum;
	
	
	// Getters and setters.
	
	public int getcID() {
		return cID;
	}
	public void setcID(int cID) {
		this.cID = cID;
	}
	
	public int getcUserID() {
		return cUserID;
	}
	public void setcUserID(int cUserID) {
		this.cUserID = cUserID;
	}
	
	public int getcShopID() {
		return cShopID;
	}
	public void setcShopID(int cShopID) {
		this.cShopID = cShopID;
	}
	
	public String getcContent() {
		return cContent;
	}
	public void setcContent(String cContent) {
		this.cContent = cContent;
	}
	
	public float getcCost() {
		return cCost;
	}
	public void setcCost(float cCost) {
		this.cCost = cCost;
	}
	
	public float getcTasteScore() {
		return cTasteScore;
	}
	public void setcTasteScore(float cTasteScore) {
		this.cTasteScore = cTasteScore;
	}
	
	public float getcEnvirScore() {
		return cEnvirScore;
	}
	public void setcEnvirScore(float cEnvirScore) {
		this.cEnvirScore = cEnvirScore;
	}
	
	public float getcServiceScore() {
		return cServiceScore;
	}
	public void setcServiceScore(float cServiceScore) {
		this.cServiceScore = cServiceScore;
	}
	
	public int getcLikeNum() {
		return cLikeNum;
	}
	public void setcLikeNum(int cLikeNum) {
		this.cLikeNum = cLikeNum;
	}
	
	public int getcDislikeNum() {
		return cDislikeNum;
	}
	public void setcDislikeNum(int cDislikeNum) {
		this.cDislikeNum = cDislikeNum;
	}
	
	public int getcStarNum() {
		return cStarNum;
	}
	public void setcStarNum(int cStarNum) {
		this.cStarNum = cStarNum;
	}
	
}
