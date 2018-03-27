package Model;

public class Shop {

	// Shop id
	private int sID;
	// Shop name
	private String sName;
	// City where shop locates.
	private String sCity;
	// District where shop locates.
	private String sDistrict;
	// Shop address
	private String sAddress;
	// Shop telephone number
	private String sTelephone;
	// Shop head image's URL
	private String sHeadImage;
	// Shop average cost for each person
	private float sAverageCost;
	// Shop type or called "²ËÏµ"
	private int sType;
	// Shop average taste score, 0.0 - 10.0
	private float sTasteScore;
	// Shop average environment score, 0.0 - 10.0
	private float sEnvirScore;
	// Shop average service score, 0.0 - 10.0
	private float sServiceScore;
	// Num of Comments to this shop.
	private int sCommentsNum;
	// Merchant mark, like "Grading-AAAA".
	private String sMark;
	
	
	// Getters and setters.
	
	public int getsID() {
		return sID;
	}
	public void setsID(int sID) {
		this.sID = sID;
	}
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	
	public String getsCity() {
		return sCity;
	}
	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	
	public String getsDistrict() {
		return sDistrict;
	}
	public void setsDistrict(String sDistrict) {
		this.sDistrict = sDistrict;
	}
	
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	public String getsTelephone() {
		return sTelephone;
	}
	public void setsTelephone(String sTelephone) {
		this.sTelephone = sTelephone;
	}
	
	public String getsHeadImage() {
		return sHeadImage;
	}
	public void setsHeadImage(String sHeadImage) {
		this.sHeadImage = sHeadImage;
	}
	
	public float getsAverageCost() {
		return sAverageCost;
	}
	public void setsAverageCost(float sAverageCost) {
		this.sAverageCost = sAverageCost;
	}
	
	public int getsType() {
		return sType;
	}
	public void setsType(int sType) {
		this.sType = sType;
	}
	
	public float getsTasteScore() {
		return sTasteScore;
	}
	public void setsTasteScore(float sTasteScore) {
		this.sTasteScore = sTasteScore;
	}
	
	public float getsEnvirScore() {
		return sEnvirScore;
	}
	public void setsEnvirScore(float sEnvirScore) {
		this.sEnvirScore = sEnvirScore;
	}
	
	public float getsServiceScore() {
		return sServiceScore;
	}
	public void setsServiceScore(float sServiceScore) {
		this.sServiceScore = sServiceScore;
	}
	
	public int getsCommentsNum() {
		return sCommentsNum;
	}
	public void setsCommentsNum(int sCommentsNum) {
		this.sCommentsNum = sCommentsNum;
	}
	
	public String getsMark() {
		return sMark;
	}
	public void setsMark(String sMark) {
		this.sMark = sMark;
	}
	
}
