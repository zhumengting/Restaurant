package com.food.view;

public class ReviewItem {
	private String date="";
	private String review_id="";
	private String userName="";
	private String text="";
	private String votes="";
	private int stars;
	private String user_id = "";
	/**
	 * @return the review_id
	 */
	public String getReview_id() {
		return review_id;
	}
	/**
	 * @param review_id the review_id to set
	 */
	public void setReview_id(String review_id) {
		this.review_id = review_id;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the votes
	 */
	public String getVotes() {
		return votes;
	}
	/**
	 * @param votes the votes to set
	 */
	public void setVotes(String votes) {
		this.votes = votes;
	}
	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}
	/**
	 * @param stars the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}
	
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
}
