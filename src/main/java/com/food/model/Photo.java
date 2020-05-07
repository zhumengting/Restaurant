package com.food.model;

public class Photo {
	private String photo_id = "";
	private String business_id = "";
	private String caption ="";
	private String label="";
	/**
	 * @return the photo_id
	 */
	public String getPhoto_id() {
		return photo_id;
	}
	/**
	 * @param photo_id the photo_id to set
	 */
	public void setPhoto_id(String photo_id) {
		this.photo_id = photo_id;
	}
	/**
	 * @return the business_id
	 */
	public String getBusiness_id() {
		return business_id;
	}
	/**
	 * @param business_id the business_id to set
	 */
	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}
	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
	}
	/**
	 * @return the label
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * @param label the label to set
	 */
	public void setLabel(String label) {
		this.label = label;
	}
}
