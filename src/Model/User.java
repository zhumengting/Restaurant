package com.food.model;

public class User {
 private String user_id="";
 private String compliments="";
 private String elite="";
 private String password="";
 private int fans;
  private float average_stars;
 /**
 * @return the user_id
 */
  
public User(String id,String pass){
	this.user_id=id;
	this.password=pass;
}
public String getUser_id() {
	return user_id;
}
/**
 * @param user_id the user_id to set
 */
public void setUser_id(String user_id) {
	this.user_id = user_id;
}
/**
 * @return the average_stars
 */
public float getAverage_stars() {
	return average_stars;
}
/**
 * @param average_stars the average_stars to set
 */
public void setAverage_stars(float average_stars) {
	this.average_stars = average_stars;
}
/**
 * @return the compliments
 */
public String getCompliments() {
	return compliments;
}
/**
 * @param compliments the compliments to set
 */
public void setCompliments(String compliments) {
	this.compliments = compliments;
}
/**
 * @return the elite
 */
public String getElite() {
	return elite;
}
/**
 * @param elite the elite to set
 */
public void setElite(String elite) {
	this.elite = elite;
}
/**
 * @return the fans
 */
public int getFans() {
	return fans;
}
/**
 * @param fans the fans to set
 */
public void setFans(int fans) {
	this.fans = fans;
}
/**
 * @return the friends
 */
public String getFriends() {
	return friends;
}
/**
 * @param friends the friends to set
 */
public void setFriends(String friends) {
	this.friends = friends;
}
/**
 * @return the name
 */
public String getName() {
	return name;
}
/**
 * @param name the name to set
 */
public void setName(String name) {
	this.name = name;
}
/**
 * @return the review_count
 */
public int getReview_count() {
	return review_count;
}
/**
 * @param review_count the review_count to set
 */
public void setReview_count(int review_count) {
	this.review_count = review_count;
}
/**
 * @return the type
 */
public String getType() {
	return type;
}
/**
 * @param type the type to set
 */
public void setType(String type) {
	this.type = type;
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
 * @return the yelping_since
 */
public String getYelping_since() {
	return yelping_since;
}
/**
 * @param yelping_since the yelping_since to set
 */
public void setYelping_since(String yelping_since) {
	this.yelping_since = yelping_since;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
private String friends="";
 private String name="";
 private int review_count;
 private String type="";
 private String votes="";
 private String yelping_since="";
 
 
}
