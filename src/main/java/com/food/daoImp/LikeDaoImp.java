package com.food.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.food.dao.LikeDao;
import com.food.model.Business;
import com.food.util.DbUtil;
import com.food.util.parseJSON;
import com.food.view.ReviewItem;

public class LikeDaoImp extends JdbcDaoSupport implements LikeDao {
	 public LikeDaoImp() {  super();  }  
	 private Connection conn=null;
	 private PreparedStatement psmt=null;
	 private ResultSet rs=null;
	 private DbUtil dbUtil=new DbUtil();
	@SuppressWarnings("unchecked")
	@Override
	public void AddLikeRestaurant(String userid, String restaurantid) {
		// TODO Auto-generated method stub
		List<String> lists=new ArrayList<String>();
        String sql="select * from user where id ='"+userid+"'";  
		try {			
			conn=dbUtil.getCon();
        	psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while (rs.next()) {
				String result=rs.getString("likeBusiness");
				List<String> newlists=parseJSON.parseList(result);
            	for (int i =0;i<newlists.size();i++) {
            		lists.add(newlists.get(i));
            	}
			}
			lists.add(restaurantid);
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
		int rs2;
		String addedString=parseJSON.parseJSONListToString(lists);
        String sql2 = "update user set likeBusiness= '"+addedString+"' where id= '"+userid+"'";
        System.out.println(sql2);
	   	try {			
			conn=dbUtil.getCon();
        	psmt=conn.prepareStatement(sql2);
        	rs2=psmt.executeUpdate();
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

	}
	@SuppressWarnings("unchecked")
	@Override
	public void DeleteLikeRestaurant(String userid, String restaurantid) {
		List<String> lists=new ArrayList<String>();
        String sql="select * from user where id ='"+userid+"'";  
		try {			
			conn=dbUtil.getCon();
        	psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			while (rs.next()) {
				String result=rs.getString("likeBusiness");
				List<String> newlists=parseJSON.parseList(result);
            	for (int i =0;i<newlists.size()&&newlists.get(i)!=restaurantid;i++) {
            		lists.add(newlists.get(i));
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
		
		int rs2;
		String addedString=parseJSON.parseJSONListToString(lists);
        String sql2 = "update user set likeBusiness= '"+addedString+"' where id= '"+userid+"'";
        System.out.println(sql2);
	   	try {			
			conn=dbUtil.getCon();
        	psmt=conn.prepareStatement(sql2);
        	rs2=psmt.executeUpdate();
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
		
	}
	

}
