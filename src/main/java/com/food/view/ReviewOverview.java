package com.food.view;

public class ReviewOverview {

	private int fiveStarCount =0;
	private int fourStarCount=0;
	private int threeStarCount=0;
	private int twoStarCount=0;
	private int oneStarCount=0;
	private int zeroStarCount=0;
	private int allReviewCount=0;
	/**
	 * @return the fiveStarCount
	 */
	public int getFiveStarCount() {
		return fiveStarCount;
	}
	public int getFiveStarPercent(){
		if(this.allReviewCount!=0)
		return fiveStarCount/this.allReviewCount*100;
		return 0;
	}
	/**
	 * @param fiveStarCount the fiveStarCount to set
	 */
	public void setFiveStarCount(int fiveStarCount) {
		this.fiveStarCount = fiveStarCount;
	}
	/**
	 * @return the fourStarCount
	 */
	public int getFourStarCount() {
		return fourStarCount;
	}
	public int getFourStarPercent(){
		if(this.allReviewCount!=0)
		return fourStarCount/this.allReviewCount*100;
		return 0;
	}
	/**
	 * @param fourStarCount the fourStarCount to set
	 */
	public void setFourStarCount(int fourStarCount) {
		this.fourStarCount = fourStarCount;
	}
	/**
	 * @return the threeStarCount
	 */
	public int getThreeStarCount() {
		return threeStarCount;
	}
	public int getThreeStarPercent(){
		if(this.allReviewCount!=0)
		return threeStarCount/this.allReviewCount*100;
		return 0;
	}
	/**
	 * @param threeStarCount the threeStarCount to set
	 */
	public void setThreeStarCount(int threeStarCount) {
		this.threeStarCount = threeStarCount;
	}
	/**
	 * @return the twoStarCount
	 */
	public int getTwoStarCount() {
		return twoStarCount;
	}
	public int getTwoStarPercent(){
		if(this.allReviewCount!=0)
		return twoStarCount/this.allReviewCount*100;
		return 0;
		}
	/**
	 * @param twoStarCount the twoStarCount to set
	 */
	public void setTwoStarCount(int twoStarCount) {
		this.twoStarCount = twoStarCount;
	}
	/**
	 * @return the oneStarCount
	 */
	public int getOneStarCount() {
		return oneStarCount;
	}
	public int getOneStarPercent(){
		if(this.allReviewCount!=0)
		return oneStarCount/this.allReviewCount*100;
		return 0;
	}
	/**
	 * @param oneStarCount the oneStarCount to set
	 */
	public void setOneStarCount(int oneStarCount) {
		
		this.oneStarCount = oneStarCount;
	}
	/**
	 * @return the zeroStarCount
	 */
	public int getZeroStarCount() {
		return zeroStarCount;
	}
	/**
	 * @param zeroStarCount the zeroStarCount to set
	 */
	public void setZeroStarCount(int zeroStarCount) {
		this.zeroStarCount = zeroStarCount;
	}
	/**
	 * @return the allReviewCount
	 */
	public int getAllReviewCount() {
		return allReviewCount;
	}
	/**
	 * @param allReviewCount the allReviewCount to set
	 */
	public void setAllReviewCount() {
		this.allReviewCount = this.zeroStarCount+this.twoStarCount+this.threeStarCount+this.fourStarCount+this.fiveStarCount;
	}
	
	
}
