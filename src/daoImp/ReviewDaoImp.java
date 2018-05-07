package com.food.daoImp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.food.dao.ReviewDao;

import com.food.view.ReviewItem;
import com.food.view.ReviewOverview;

public class ReviewDaoImp extends JdbcDaoSupport implements ReviewDao{
	public ReviewDaoImp() {  super();  }  
	//返回店铺评论列表
	public List<ReviewItem> getSingleBusinessReviewList(String businessId) {
	//user 表中无信息
		/*String sql = "select date,review.id,text,review.votes,stars,user_id "
		+ "from review "
		+ "where business_id = '"+businessId+"'";*/
		String sql = "select date,review.id,text,review.votes,stars,user.name,user.id "
				+ "from review,user "
				+ "where business_id = '"+businessId+"' and user.id = review.user_id";
		final List<ReviewItem> reviewList = new ArrayList<ReviewItem>();
		this.getJdbcTemplate().query(sql,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	ReviewItem reviewItem=new ReviewItem();
            	reviewItem.setUserName(rs.getString("name"));
            	reviewItem.setDate(rs.getString("date"));
            	reviewItem.setStars(rs.getInt("stars"));
            	reviewItem.setReview_id(rs.getString("review.id"));
            	reviewItem.setUser_id(rs.getString("id"));
            	reviewItem.setText(rs.getString("text"));
            	//reviewItem.setUserName(rs.getString("user_id"));
            	reviewItem.setVotes(rs.getString("review.votes"));
            	reviewList.add(reviewItem);
            }
           }
          );    
		return reviewList;
	}
	public ReviewOverview getSingleBusinessReviewOverview(String businessId) {
		final ReviewOverview reviewOverview = new ReviewOverview();
		String sql = "SELECT  stars,count(*) as xstarsCount FROM review "
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
     
}
