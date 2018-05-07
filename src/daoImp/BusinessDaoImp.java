package com.food.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import com.food.dao.BusinessDao;
import com.food.model.Business;
import com.food.service.RecommandorService;
import com.food.util.DbUtil;
import com.food.util.JDBC;
import com.food.view.BItem;

public class BusinessDaoImp extends JdbcDaoSupport implements BusinessDao {
	
	DbUtil dbUtil = new DbUtil();
	
	private RecommandorService recommandor = new RecommandorService();

	// SQL doing Natural Language FULL-TEXT SEARCH operation.
	private static String SQL_NL_FULL_TEXT_SEARCH = "select business.id, photo.id, "
			+ "attributes, categories, city, full_address, hours, latitude, "
			+ "longitude, name, neighborhoods, open, review_count, stars, state "
			+ "from business left join photo on business.id = photo.business_id "
			+ "where match(name, full_address) against('";

	public List<BItem> QueryBusiness(List<String> conditions) {

		final List<BItem> businesses = new ArrayList<BItem>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = SQL_NL_FULL_TEXT_SEARCH;
		String conditionStr = "";
		for (String condition : conditions) {
			conditionStr += (condition + ",");
		}
		sql += (conditionStr + "') and match(categories) against('" + conditionStr);
		// Consider the stars and review_count of business as popularity. 
		sql += "') group by business.id order by (stars + log(review_count)) desc;";

		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem business = new BItem();
				business.setBusiness_id(rs.getString("business.id"));
				business.setImage_id(rs.getString("photo.id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
				businesses.add(business);
			}
		});
		
		return recommandor.Dithering(businesses, 2.0f);
	}

	public List<Business> getAllFiveStarsBusiness() {
		List<Business> businesses = new ArrayList<Business>();
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		try {

			conn = dbUtil.getCon();
			String sql = "select * from business where stars=5";

			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while (rs.next()) {
				Business b = new Business();
				b.setBusiness_id(rs.getString(2));
				businesses.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				dbUtil.closeCon(conn);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return businesses;

	}

	public BusinessDaoImp() {
		super();
	}

	// get Business List order by score
	public List<BItem> getHighScoreBusinessList(int rn) {
		String sql = "select * from highscore_business";
		final List<BItem> businessList = new ArrayList<BItem>();
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem bItem = new BItem();
				bItem.setBusiness_id(rs.getString("bs_id"));
				bItem.setImage_id(rs.getString("ph_id"));
				bItem.setNeighborhoods(rs.getString("neighborhoods"));
				bItem.setCategories(rs.getString("categories"));
				bItem.setName(rs.getString("name"));
				bItem.setStars(rs.getFloat("stars"));
				businessList.add(bItem);
			}
		});
		return businessList;
	}

	public List<Business> getHottestBusinessList() {
		// TODO Auto-generated method stub
		String sql = "select * from hottest_view";
		final List<Business> businessList = new ArrayList<Business>();
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				Business business = new Business();
				business.setBusiness_id(rs.getString("id"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setStars(rs.getFloat("stars"));
				// siness.setReview_count(rs.getFloat("review_count"));
				businessList.add(business);
			}
		});
		return businessList;
	}

	// get Business by id
	public BItem getBusinessById(String id) {
		String sql = "select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
				+ "from business,photo where photo.business_id=business.id and " + "business.id=?";
		final BItem business = new BItem();
		this.getJdbcTemplate().query(sql, new Object[] { id }, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				business.setBusiness_id(rs.getString("bs_id"));
				business.setImage_id(rs.getString("ph_id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
			}
		});
		return business;
	}

	public List<BItem> getBusinessListOfSingleCity(String cityName) {
		final List<BItem> businessOfCity = new ArrayList<BItem>();
		String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
				+ "from business,photo " + "where photo.business_id=business.id and business.city='" + cityName + "'"
				+ " group by business_id";
		/* businessOfCity = this.getJdbcTemplate().queryForList(sql); */
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem business = new BItem();
				business.setBusiness_id(rs.getString("business_id"));
				business.setImage_id(rs.getString("id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
				businessOfCity.add(business);
			}
		});
		return businessOfCity;
	}

	// get businessList of selected countryName
	public List<BItem> getBusinessListOfSingleCountry(String countryName) {
		final List<BItem> businessOfCountry = new ArrayList<BItem>();
		String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
				+ "from business,photo " + "where photo.business_id=business.id and business.categories like '%"
				+ countryName + "%' " + "group by business_id";
		/* businessOfCity = this.getJdbcTemplate().queryForList(sql); */
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem business = new BItem();
				business.setBusiness_id(rs.getString("business_id"));
				business.setImage_id(rs.getString("id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
				businessOfCountry.add(business);
			}
		});
		return businessOfCountry;
	}

	// get single business by id[String]
	public BItem getSingleBusinessById(String id) {
		String sql = "select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
				+ "from business,photo " + "where photo.business_id=business.id and business_id = '" + id + "' "
				+ "group by business_id";
		final BItem business = new BItem();
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				business.setBusiness_id(rs.getString("bs_id"));
				business.setImage_id(rs.getString("ph_id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
			}
		});
		return business;
	}

	public List<BItem> getTopRewBusiness() {
		final List<BItem> businessTop12 = new ArrayList<BItem>();
		String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
				+ "from business,photo " + "order by review_count desc limit 12";
		/* businessOfCity = this.getJdbcTemplate().queryForList(sql); */
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem business = new BItem();
				business.setBusiness_id(rs.getString("business_id"));
				business.setImage_id(rs.getString("id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
				businessTop12.add(business);
			}
		});
		return businessTop12;
	}

	public List<BItem> getChoosenBusinessList(String choosenCategorie) {
		// TODO Auto-generated method stub
		String sql = "select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
				+ "from business,photo " + "where photo.business_id=business.id and categories like '%"
				+ choosenCategorie + "%'" + "group by business_id";
		final List<BItem> businesses = new ArrayList<BItem>();
		this.getJdbcTemplate().query(sql, new Object[] {}, new RowCallbackHandler() {
			public void processRow(ResultSet rs) throws SQLException {
				BItem business = new BItem();
				business.setBusiness_id(rs.getString("bs_id"));
				business.setImage_id(rs.getString("ph_id"));
				business.setAttributes(rs.getString("attributes"));
				business.setFull_address(rs.getString("full_address"));
				business.setHours(rs.getString("hours"));
				business.setLatitude(rs.getFloat("latitude"));
				business.setLongitude(rs.getFloat("longitude"));
				business.setNeighborhoods(rs.getString("neighborhoods"));
				business.setCategories(rs.getString("categories"));
				business.setCity(rs.getString("city"));
				business.setName(rs.getString("name"));
				business.setOpen(rs.getInt("open"));
				business.setReview_count(rs.getInt("Review_count"));
				business.setStars(rs.getFloat("stars"));
				business.setState(rs.getString("state"));
				businesses.add(business);
			}
		});
		return businesses;

	}

}
