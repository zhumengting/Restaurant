package Model;

public class Image {

	// Image id
	private int iID;
	// Image's URL
	private String iUrl;
	// ID of comment that contains this image.
	private int iCommentID;
	
	
	// Getters and setters.
	
	public int getiID() {
		return iID;
	}
	public void setiID(int iID) {
		this.iID = iID;
	}
	
	public String getiUrl() {
		return iUrl;
	}
	public void setiUrl(String iUrl) {
		this.iUrl = iUrl;
	}
	
	public int getiCommentID() {
		return iCommentID;
	}
	public void setiCommentID(int iCommentID) {
		this.iCommentID = iCommentID;
	}
	
}
