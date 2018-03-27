package Model;

public class Cuisine {

	// Cuisine id
	private int cuID;
	// Cuisine name
	private String cuName;
	// Cuisine price
	private float cuPrice;
	// Shop id that offers the cuisine.
	private int cuShopID;
	
	
	// Getters and setters.
	
	public int getCuID() {
		return cuID;
	}
	public void setCuID(int cuID) {
		this.cuID = cuID;
	}
	
	public String getCuName() {
		return cuName;
	}
	public void setCuName(String cuName) {
		this.cuName = cuName;
	}
	
	public float getCuPrice() {
		return cuPrice;
	}
	public void setCuPrice(float cuPrice) {
		this.cuPrice = cuPrice;
	}
	
	public int getCuShopID() {
		return cuShopID;
	}
	public void setCuShopID(int cuShopID) {
		this.cuShopID = cuShopID;
	}
	
}
