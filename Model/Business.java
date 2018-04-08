package Models;

public class Business {

	private String business_id="";
	private String attributes="";
	private String neighborhoods="";
	private String type="";
	private String name="";
	private String state="";
	private String city="";
	private String full_address="";
	private String hours="";
	private String categories="";
	
	private boolean open;
	private int review_count;
	private float stars;
	private float latitude;
	private float longitude;
	/**
	 * @return the attributes
	 */
	public String getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the neighborhoods
	 */
	public String getNeighborhoods() {
		return neighborhoods;
	}
	/**
	 * @param neighborhoods the neighborhoods to set
	 */
	public void setNeighborhoods(String neighborhoods) {
		this.neighborhoods = neighborhoods;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the full_address
	 */
	public String getFull_address() {
		return full_address;
	}
	/**
	 * @param full_address the full_address to set
	 */
	public void setFull_address(String full_address) {
		this.full_address = full_address;
	}
	/**
	 * @return the hours
	 */
	public String getHours() {
		return hours;
	}
	/**
	 * @param hours the hours to set
	 */
	public void setHours(String hours) {
		this.hours = hours;
	}
	/**
	 * @return the categories
	 */
	public String getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(String categories) {
		this.categories = categories;
	}
	/**
	 * @return the open
	 */
	public boolean isOpen() {
		return open;
	}
	/**
	 * @param open the open to set
	 */
	public void setOpen(boolean open) {
		this.open = open;
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
	 * @return the stars
	 */
	public float getStars() {
		return stars;
	}
	/**
	 * @param stars the stars to set
	 */
	public void setStars(float stars) {
		this.stars = stars;
	}
	/**
	 * @return the latitude
	 */
	public float getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public float getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(float longitude) {
		this.longitude = longitude;
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
	
}
