package com.food.daoImp;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.food.dao.ReviewDao;
import com.food.model.Review;
import com.food.view.ReviewItem;
import com.food.view.ReviewOverview;

public class ReviewDaoImp extends JdbcDaoSupport implements ReviewDao{
	public ReviewDaoImp() {  super();  }  
	
	//get Business List order by score
	public  List<Review> getReviewListByUserId(String Uid){  
		String sql="select business_id,date,text "
	        		+ "from review where user_id=? ";
	        final List<Review> reviewList=new ArrayList<Review>();
	        this.getJdbcTemplate().query(sql,new Object[] {Uid}, new RowCallbackHandler() {
	            public void processRow(ResultSet rs) throws SQLException {
	            	Review review=new Review();
	            	review.setBusiness_id(rs.getString("business_id"));  
	            	review.setDate(rs.getString("date"));  
	            	review.setText(rs.getString("text"));  
	            	reviewList.add(review);
	            }
	           }
	          );    
	          return reviewList;
	    } 
	//返回店铺评论列表
	public List<ReviewItem> getSingleBusinessReviewList(String businessId,int start,int selectCounts) {
	//user 表中无信息
		String sql = "select str_to_date(date,'%Y-%m-%d') as date,review.id,text,review.votes,stars,user.name "
		+ "from review,user "
		+ "where user.id = review.user_id and business_id = '"+businessId+"' order by date desc limit  "+start+","+selectCounts;
		/*String sql = "select date,review.id,text,review.votes,stars,user.name,user.id "
				+ "from review,user "
				+ "where business_id = '"+businessId+"' and user.id = review.user_id";*/
		final List<ReviewItem> reviewList = new ArrayList<ReviewItem>();
		this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	ReviewItem reviewItem=new ReviewItem();
            	reviewItem.setDate(rs.getDate("date").toString());
            	reviewItem.setStars(rs.getInt("stars"));
            	reviewItem.setReview_id(rs.getString("review.id"));
            	reviewItem.setUser_id(rs.getString("id"));
            	reviewItem.setText(rs.getString("text"));
            	reviewItem.setUserName(rs.getString("user.name"));
            	reviewItem.setVotes(rs.getString("review.votes"));
            	reviewList.add(reviewItem);
            }
           }
          );   
	
		return reviewList;
	}
	public ReviewOverview getSingleBusinessReviewOverview(String businessId) {
		final ReviewOverview reviewOverview = new ReviewOverview();
		String sql = "SELECT  stars,count(*) as xstarsCount FROM big_restaurant.review "
				+ "where business_id = '"+businessId+"'"
						+ " group by stars order by stars ";
		this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	int index = rs.getInt("stars");
            	switch(index){
            	case 0:
                	reviewOverview.setZeroStarCount(rs.getInt("xstarsCount"));
            		break;
            	case 1:
            	reviewOverview.setOneStarCount(rs.getInt("xstarsCount"));
            		break;
            	case 2:
                	reviewOverview.setTwoStarCount(rs.getInt("xstarsCount"));
            		break;
            	case 3:
                	reviewOverview.setThreeStarCount(rs.getInt("xstarsCount"));

            		break;
            	case 4:
                	reviewOverview.setFourStarCount(rs.getInt("xstarsCount"));

            		break;
            	case 5:
                	reviewOverview.setFiveStarCount(rs.getInt("xstarsCount"));
            	}
            }
           }
          );    
		reviewOverview.setAllReviewCount();
		return reviewOverview;
	}
	public int singleBusinessReviewCount(String businessId) {
		String sql = "select count(*) from big_restaurant.review where business_id = '"+businessId+"'";
		int num  =this.getJdbcTemplate().queryForInt(sql);
		return num;
	}
	@Override
	public boolean addNewReview(String businessId, String userid, String review_content,int stars) {
		 Date today = new Date();  
		
		 String id = UUID.randomUUID().toString();
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");  
		 String dateNowStr = sdf.format(today);  
		 System.out.println(id);
	 	String sql = "insert into review(id,business_id,user_id,text,stars,date) values"
	 			+ "('"+id+"','"+businessId+"','"+userid+"','"+review_content+"',"+stars+",'"+dateNowStr+"');";
	   	this.getJdbcTemplate().update(sql);
	  
		return true;
	}
	@Override
	public int singleUserReviewCount(String userid) {
		String sql = "SELECT count(*) FROM big_restaurant.review "
				+ "where user_id = '"+userid+"'";
		int num  =this.getJdbcTemplate().queryForInt(sql);
		
		return num;
	}
	@Override
	public List<String> getSingleUserReviewList(String userid) {
		String sql = "select * from review "
				+ "where user_id= '"+userid+"';";
			
				final List<String> reviewList = new ArrayList<String>();
				this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
		            public void processRow(ResultSet rs) throws SQLException {
		            	reviewList.add(rs.getString("business_id"));
		            }
		           }
		          );   
			
				return reviewList;
	}
}
