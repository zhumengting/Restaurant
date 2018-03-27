package Model;


public class User {
	
	// User id
	private int uID;
	// User name
	private String uName;
	// User address
	private String uAddress;
	// User head image's URL
	private String uHeadImage;
	// User signature
	private String uSign;
	// Num of user reviews
	private int uReviewsNum;
	// Num of user photos
	private int uPhotosNum;
	// Num of user friends
	private int uFriendsNum;
	// Num of user fans
	private int uFansNum;
	// Num of user stars
	private int uStarsNum;
	
	
	// Getters and setters.
	
	public int getuID() {
		return uID;
	}
	public void setuID(int uID) {
		this.uID = uID;
	}
	
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	
	public String getuAddress() {
		return uAddress;
	}
	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}
	
	public String getuHeadImage() {
		return uHeadImage;
	}
	public void setuHeadImage(String uHeadImage) {
		this.uHeadImage = uHeadImage;
	}
	
	public String getuSign() {
		return uSign;
	}
	public void setuSign(String uSign) {
		this.uSign = uSign;
	}
	
	public int getuReviewsNum() {
		return uReviewsNum;
	}
	public void setuReviewsNum(int uReviewsNum) {
		this.uReviewsNum = uReviewsNum;
	}
	
	public int getuPhotosNum() {
		return uPhotosNum;
	}
	public void setuPhotosNum(int uPhotosNum) {
		this.uPhotosNum = uPhotosNum;
	}
	
	public int getuFriendsNum() {
		return uFriendsNum;
	}
	public void setuFriendsNum(int uFriendsNum) {
		this.uFriendsNum = uFriendsNum;
	}	
	
	public int getuFansNum() {
		return uFansNum;
	}
	public void setuFansNum(int uFansNum) {
		this.uFansNum = uFansNum;
	}
	
	public int getuStarsNum() {
		return uStarsNum;
	}
	public void setuStarsNum(int uStarsNum) {
		this.uStarsNum = uStarsNum;
	}	
	
}
