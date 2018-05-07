package com.food.daoImp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.food.dao.PhotoDao;
import com.food.model.Business;
import com.food.model.Photo;
import com.food.util.DbUtil;

public class PhotoDaoImp implements PhotoDao {

	DbUtil dbUtil=new DbUtil();
	
	
	@Override
	public List<Photo> getPicbyBusiness(List<Business> businesses) {
		List<Photo>Photos=new ArrayList<Photo>();
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		try {
			for(int i=0;i<businesses.size();i++) {
				conn=dbUtil.getCon();
				String sql="select * from photo where business_id=?";
				
				psmt=conn.prepareStatement(sql);
				psmt.setString(1, businesses.get(i).getBusiness_id());
				rs=psmt.executeQuery();
				if (rs.next()) {
					Photo p=new Photo();
					p.setPhoto_id(rs.getString(1));
					p.setBusiness_id(rs.getString(2));
					p.setCaption(rs.getString(3));
					p.setLabel(rs.getString(4));
					Photos.add(p);
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
		return Photos;
	}

}
