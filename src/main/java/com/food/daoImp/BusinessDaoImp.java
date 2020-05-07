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
import com.food.model.Photo;
import com.food.service.RecommandorService;
import com.food.util.DbUtil;
import com.food.util.JDBC;
import com.food.util.StringUtil;
import com.food.util.parseJSON;
import com.food.view.BItem;

public class BusinessDaoImp extends JdbcDaoSupport implements BusinessDao{
	DbUtil dbUtil=new DbUtil();
	// SQL doing INSERT operation.
	private RecommandorService recommandor = new RecommandorService();

	// SQL doing Natural Language FULL-TEXT SEARCH operation.
	private static String SQL_NL_FULL_TEXT_SEARCH = "select business.id, photo.id, "
			+ "attributes, categories, city, full_address, hours, latitude, "
			+ "longitude, name, neighborhoods, open, review_count, stars, state "
			+ "from business left join photo on business.id = photo.business_id "
			+ "where match(name, full_address) against('";
	private static String SQL_NL_FULL_TEXT_SEARCH2 = "select count(distinct business.id) "
			+ "from business left join photo on business.id = photo.business_id "
			+ "where match(name, full_address) against('";
//搜索栏
	public List<BItem> QueryBusiness(List<String> conditions,int start,int end) {

		final List<BItem> businesses = new ArrayList<BItem>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = SQL_NL_FULL_TEXT_SEARCH;
		String conditionStr =conditions.get(0);
		int n=conditions.size();
		for(int i=1;i<n;i++) {
			
			conditionStr += (","+conditions.get(i));
		}
	
	
		sql += (conditionStr + "') and match(categories) against('" + conditionStr);
		// Consider the stars and review_count of business as popularity. 
		sql += "') group by business.id order by (stars + log(review_count)) desc limit " +start+","+end;

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
		// SQL doing Natural Language FULL-TEXT SEARCH operation.

//主页五分好店
	public List<Business>getAllFiveStarsBusiness(){
		List<Business>businesses=new ArrayList<Business>();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			
			conn=dbUtil.getCon();
			String sql="select * from business where stars=5";
			
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while (rs.next()) {
				Business b=new Business();
				b.setBusiness_id(rs.getString("id"));
				businesses.add(b);
			}
		}catch (SQLException e) {
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
public BusinessDaoImp() {  super();  }  
	
	//get Business List order by score
	public  List<BItem> getHighScoreBusinessList(int start,int end){  
        String sql="select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
        		+ "from business,photo "
        		+ "where photo.business_id=business.id"
        				+ " group by business_id order by stars*5000+review_count desc limit " +start+","+end+";";
        final List<BItem> businessList=new ArrayList<BItem>();
        this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	BItem business=new BItem();
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
            	businessList.add(business);
            }
           }
          );    
          return businessList;
          
    }  
	
	public List<BItem> getHottestBusinessList(int start,int end) {
		final List<BItem> businessHot = new ArrayList<BItem>();
		String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
        		+ "from business,photo "
        		+ "where photo.business_id=business.id"
        				+ " group by business_id order by review_count desc limit " +start+","+end+";";
		/*businessOfCity  =  this.getJdbcTemplate().queryForList(sql);*/
		 this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
				public void processRow(ResultSet rs) throws SQLException {
					BItem business=new BItem();
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
	            	businessHot.add(business);
				}
			 }
			);
		return businessHot;
	}

	
	//get Business by id
		public  BItem getBusinessById(String id){  
	        String sql="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
	        		+ "from business,photo where photo.business_id=business.id and "
	        		+ "business.id=?";
	        final BItem business=new BItem();
	        this.getJdbcTemplate().query(sql,new Object[] {id}, new RowCallbackHandler() {
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
	           }
	          );    
	          return business;
	    }  


		//get businessList of selected cityName
		public List<BItem> getBusinessListOfSingleCity(String cityName,int start,int selectCounts) {
			final List<BItem> businessOfCity = new ArrayList<BItem>();
			String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "where photo.business_id=business.id and business.city='"+cityName+"'"
	        				+ " group by business_id order by (stars + log(review_count)) desc limit " +start+","+selectCounts;
			/*businessOfCity  =  this.getJdbcTemplate().queryForList(sql);*/
			 this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						BItem business=new BItem();
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
				 }
				);
			return businessOfCity;
		}
//get businessList of selected countryName
		public List<BItem> getBusinessListOfSingleCountry(String countryName,int start,int end) {
			final List<BItem> businessOfCountry = new ArrayList<BItem>();
			String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "where photo.business_id=business.id and business.categories like '%"+countryName+"%' "
	        				+ "group by business_id order by (stars + log(review_count)) desc limit " +start+","+end+";";
			/*businessOfCity  =  this.getJdbcTemplate().queryForList(sql);*/
			 this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						BItem business=new BItem();
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
				 }
				);
			return businessOfCountry;
		}  
		//get single business by id[String]
		public  BItem getSingleBusinessById(String id){  
	        String sql="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "where photo.business_id=business.id and business_id = '"+id+"' "
	        				+ "group by business_id";
	        final BItem business=new BItem();
	        this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
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
	           }
	          );    
	          return business;
	    }
		@Override
		public List<BItem> getTopRewBusiness() {
			final List<BItem> businessTop12 = new ArrayList<BItem>();
			String sql = "select photo.business_id ,photo.id,attributes,categories,city,full_address,name,hours,neighborhoods,latitude,longitude,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "order by review_count desc limit 12";
			/*businessOfCity  =  this.getJdbcTemplate().queryForList(sql);*/
			 this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
					public void processRow(ResultSet rs) throws SQLException {
						BItem business=new BItem();
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
				 }
				);
			return businessTop12;
		}


		public List<BItem> getChoosenBusinessList(String choosenCategorie,int start,int end) {
			// TODO Auto-generated method stub
			String sql="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "where photo.business_id=business.id and categories like '%"+choosenCategorie+"%'"
	        				+ "group by business_id order by (stars + log(review_count)) desc limit " +start+","+end+";";
	        final List<BItem> businesses=new ArrayList<BItem>();
	        this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
	            public void processRow(ResultSet rs) throws SQLException {
	            	BItem business=new BItem();
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
	           }
	          );    
	          return businesses;
			
		}

		@Override
		public List<BItem> getBusinessEnvironment(String choosenCategorie,int start,int end) {
			String sql="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
	        		+ "from business,photo "
	        		+ "where photo.business_id=business.id and attributes like '%"+"\""+choosenCategorie+"\""+":true"+"%'"
	        				+ "group by bs_id order by (stars + log(review_count)) desc limit " +start+","+end+";";
		
	        final List<BItem> businesses=new ArrayList<BItem>();
	        this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
	            public void processRow(ResultSet rs) throws SQLException {
	            	BItem business=new BItem();
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
	           }
	          );    
	          return businesses;
		}

		public Map<String, Map<String, String>> getOpenTimeOfSingleBusiness(String openHour) {
			Map<String, Object> mMap = new HashMap<String, Object>();
			mMap = (Map<String, Object>) parseJSON.parseJSONStringToMap(openHour);
			Map<String, Map<String,String>> openTimeHourMap = new HashMap<String, Map<String,String>>();
			for(String mkey:mMap.keySet()){
				String mmkey = mMap.get(mkey).toString();
				Map<String,String> m_Map =(Map<String, String>) parseJSON.parseJSONStringToMap(mmkey);;
				openTimeHourMap.put(mkey, m_Map);
			}
			return openTimeHourMap;
		}
		public int cityBusinessCount(String cityName) {
			String sql = "select count(*) from business where city='"+cityName+"'";
			int num  =this.getJdbcTemplate().queryForInt(sql);
			return num;
		}


		@Override
		public int searchBusinessCount(String search) {
			// TODO Auto-generated method stub
			String sql = SQL_NL_FULL_TEXT_SEARCH2;
			List<String> conditions = StringUtil.GetSearchCondition(search);
			
			String conditionStr =conditions.get(0);
			int n=conditions.size();
			for(int i=1;i<n;i++) {
				
				conditionStr += (","+conditions.get(i));
			}
			sql += (conditionStr + "') and match(categories) against('" + conditionStr);
			// Consider the stars and review_count of business as popularity. 
			sql += "');";
			int num  =this.getJdbcTemplate().queryForInt(sql);
			return num;
		}


		@Override
		public int getAllNumber() {
			String sql = "select count(*) from business";
			int num  =this.getJdbcTemplate().queryForInt(sql);
			return num;
		}

		@Override
		public int categoriesBusinessCount(String categories) {
			String sql = "select count(*) from business where categories like '%"+categories+"%' ";
			int num  =this.getJdbcTemplate().queryForInt(sql);
			return num;
		}

		@Override
		public int EnvBusinessCount(String categories) {
			String sql = "select count(*) from business where attributes like '%"+categories+"%' ";
			int num  =this.getJdbcTemplate().queryForInt(sql);
			return num;
		}


		public List<BItem> getRecommendBusiness(int start,int end){
			List<BItem> businessHot = new ArrayList<BItem>();
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			try {
				
				conn=dbUtil.getCon();
				String sql = "select (business.stars*1000+business.review_count)as jiaquan,business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,"
						+ "hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state" 
						+" from business,photo where photo.business_id=business.id group by bs_id order by jiaquan desc limit " +start+","+end+";";
				
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while (rs.next()) {
					BItem business=new BItem();
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
	            	businessHot.add(business);
				}
			}catch (SQLException e) {
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
	
			return recommandor.Dithering(businessHot, 2.0f);
				
		}

		/**
		 * Get all the businesses' ids in a map which <K, V> is <index_of_business, business_id>.
		 * The index of a business is the order of its id in all the business.
		 * Note that we query the database to get the businesses' ids.
		 * 
		 * @return Business_ID_Map <Integer, String>
		 */
		public Map<Integer, String> GetAllBusinessIDsMap() {
			final String sql_QueryAllBusinessIDs = "select id from business order by id;";
			final Map<Integer, String> businessIDsMap = new HashMap<Integer, String>();
		
		        this.getJdbcTemplate().query(sql_QueryAllBusinessIDs,new Object[] {}, new RowCallbackHandler() {
		            public void processRow(ResultSet rs) throws SQLException {
		            	businessIDsMap.put(rs.getRow(), rs.getString("id"));
		            }
		           }
		          );    
			return businessIDsMap;
		}

		@Override
		public List<BItem> getRecommendBusinessBaseOnUser(String userid,int start, int end) {
			List<BItem> businessHot = new ArrayList<BItem>();
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			String[] idLists=null;
			try {
				
				conn=dbUtil.getCon();
				String sql = "select businessid_num from recommend where userid_num= '"+userid+"'";
				
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				if (rs.next()) {
					String result=rs.getString("businessid_num");
					idLists=result.split("#");
					System.out.println(idLists.length);
				}
				for(int i=start;i<end&&i<30&&i<idLists.length;i++) {
					String sql2="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
			        		+ "from business,photo "
			        		+ "where photo.business_id=business.id and business.id_num = '"+idLists[i]+"';";
					
					psmt=conn.prepareStatement(sql2);
					rs=psmt.executeQuery();
					if (rs.next()) {
						BItem business=new BItem();
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
		            	businessHot.add(business);
					}
				}
				
			}catch (SQLException e) {
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
	
			return businessHot;
		}



		@Override
		public String getUserFakeId(String trueid) {
			String sql = "select id_num from user where id = '"+trueid+"'";
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			String business ="";
			try {				
				conn=dbUtil.getCon();				
				psmt=conn.prepareStatement(sql);
				rs=psmt.executeQuery();
				while (rs.next()) {
					business=rs.getString("id_num");
				}
			}catch (SQLException e) {
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
		    return business;
		}

		@Override
		public List<BItem> getBusinessListbyIdList(List<String> ids) {
			List<BItem> businessHot = new ArrayList<BItem>();
			Connection conn=null;
			PreparedStatement psmt=null;
			ResultSet rs=null;
			try {
				
				conn=dbUtil.getCon();
				for(int i=0;i<ids.size();i++) {
					String sql2="select business.id as bs_id,photo.id as ph_id,attributes,categories,city,full_address,hours,latitude,longitude,name,neighborhoods,open,review_count,stars,state "
			        		+ "from business,photo "
			        		+ "where photo.business_id=business.id and business.id = '"+ids.get(i)+"';";
					
					psmt=conn.prepareStatement(sql2);
					rs=psmt.executeQuery();
					if (rs.next()) {
						BItem business=new BItem();
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
		            	businessHot.add(business);
					}
				}
				
			}catch (SQLException e) {
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
	
			return businessHot;
		}
		@Override
		public List<String> autoComplementSearch(String keyword) {
			String sql = "select name from business where name like '%"+keyword+"%'";
			 final List<String> businessName=new ArrayList<String>();
		        this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
		            public void processRow(ResultSet rs) throws SQLException {
		            	businessName.add(rs.getString("name"));
		            }});
			return businessName;
		}

}
