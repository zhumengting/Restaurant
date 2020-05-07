package com.food.daoImp;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.food.util.DbUtil;
import com.food.util.FileOperation;




public class RecommandDaoImp extends JdbcDaoSupport {

	/**
	 * Generate a rating matrix which row indicates user and column indicates business.
	 * The result rating matrix will be stored inside the instance of class_RecommandorService.
	 * So that we don't need to pass a new rating matrix in before calculating the similarity matrix.
	 * In addition, the result rating matrix object will be stored in "/src/main/webapp/objects/RatingMatrix.txt" by default.
	 * 
	 */
	private int[][] RatingMatrix;
	private int UserAmount;
	private int BusinessAmount;
	
	private double[][] similarityMatrix;
	/**
	 * Calculate the similarity matrix from rating matrix by collaborative filtering (CF) method.
	 * The result similarity matrix will be stored inside the instance of class_RecommandorService.
	 * Use RecommandorService.GetSimilarityMatrix() to get it.
	 * 
	 * @param type 0 indicates item-based CF; 1 indicates user-based CF
	 */
	public void CollaborativeFiltering(int type) {
		int range = 0;
		switch (type) {
		case 0: // item-based CF
			range = BusinessAmount;
			break;
		case 1: // user-based CF
			range = UserAmount;
			break;
		default:
			break;
		}
		similarityMatrix = new double[range][range];

		for (int i = 0; i < range; ++i) {
			similarityMatrix[i][i] = 1.0;
			for (int j = 0; j < i; ++j) {
				similarityMatrix[i][j] = similarityMatrix[j][i];
			}
			for (int j = i + 1; j < range; ++j) {
				similarityMatrix[i][j] = GetCosineSimilarity(i, j, type);
			}
		}
	}

	public void GenerateRatingMatrix() {
		// TODO Auto-generated method stub
		final String sql_CountUser = "select id from user order by id;";
		final String sql_CountBusiness = "select id from business order by id;";
		final String sql_SelectAllStars = "select user_id, business_id, stars from review order by user_id, business_id;";
		int userAmount = 0, businessAmount = 0;
		final Map<String, Integer> userIDList = new HashMap<String, Integer>();
		final Map<String, Integer> businessIDList = new HashMap<String, Integer>();
		final int[][] rating;
        this.getJdbcTemplate().query(sql_CountUser,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	userIDList.put(rs.getString("id"), rs.getRow());
            }
           }
          );   
        userAmount = userIDList.size();
        this.getJdbcTemplate().query(sql_CountBusiness,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	businessIDList.put(rs.getString("id"), rs.getRow());
            }
           }
          ); 
        businessAmount = businessIDList.size();
        rating = new int[userAmount][businessAmount];
        this.getJdbcTemplate().query(sql_SelectAllStars,new Object[] {}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	int userIndex = userIDList.get(rs.getString("user_id")) - 1;
    			int businessIndex = businessIDList.get(rs.getString("business_id")) - 1;
    			rating[userIndex][businessIndex] = rs.getInt("stars");
            }
           }
          ); 
        SetRatingMatrix(rating);
	}
	/**
	 * Pass a rating matrix in to calculate the similarity matrix.
	 * The row should indicate the user while the column should indicate the business.
	 * And the rating matrix will overwrite the object in "/src/main/webapp/objects/RatingMatrix.txt".
	 * 
	 * @param rating Rating matrix (int * int)
	 */
	public void SetRatingMatrix(int[][] rating) {
		RatingMatrix = rating;

		FileOperation.WriteObjectIntoFile(rating, "RatingMatrix.txt");
	}

	/**
	 * Calculate the cosine similarity of 2 items by either row index or column index.
	 * @param item1 Index of item1 (in rating matrix)
	 * @param item2 Index of item2 (in rating matrix)
	 * @param type 0 indicates item-based CF; 1 indicates user-based CF
	 * @return the cosine similarity of the 2 items
	 */
	private double GetCosineSimilarity(int item1, int item2, int type) {
		double item1x2 = 0.0, itemSquare1 = 0.0, itemSquare2 = 0.0;
		double cosSimilarity = 0.0;

		switch (type) {
		case 0: // item-based CF
			for (int i = 0; i < UserAmount; ++i) {
				item1x2 += (RatingMatrix[i][item1] * RatingMatrix[i][item2]);
				itemSquare1 += Math.pow(RatingMatrix[i][item1], 2);
				itemSquare2 += Math.pow(RatingMatrix[i][item2], 2);
			}
			break;
		case 1: // user-based CF
			for (int i = 0; i < BusinessAmount; ++i) {
				item1x2 += (RatingMatrix[item1][i] * RatingMatrix[item2][i]);
				itemSquare1 += Math.pow(RatingMatrix[item1][i], 2);
				itemSquare2 += Math.pow(RatingMatrix[item2][i], 2);
			}
			break;
		default:
			break;
		}
		if (itemSquare1 != 0.0 && itemSquare2 != 0.0)
			cosSimilarity = item1x2 / (Math.sqrt(itemSquare1) * Math.sqrt(itemSquare2));
		else
			cosSimilarity = 0.0;

		return cosSimilarity;
	}
	/**
	 * Get the similarity matrix.
	 * 
	 * @return Double dimension array of double data type
	 */
	public double[][] GetSimilarityMatrix() {
		return similarityMatrix;
	}
	/**
	 * Get all the businesses' ids in a map which <K, V> is <index_of_business, business_id>.
	 * The index of a business is the order of its id in all the business.
	 * Note that we query the database to get the businesses' ids.
	 * 
	 * @return Business_ID_Map <Integer, String>
	 */
	public Map<Integer, String> GetAllBusinessIDsMap() {
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		DbUtil dbUtil=new DbUtil();
		final Map<Integer, String> businessIDsMap = new HashMap<Integer, String>();
		try {
			
			conn=dbUtil.getCon();
			String sql_QueryAllBusinessIDs = "select id from business order by id;";
			
			psmt=conn.prepareStatement(sql_QueryAllBusinessIDs);
			rs=psmt.executeQuery();
			while (rs.next()) {
				businessIDsMap.put(rs.getRow(), rs.getString("id"));
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
		
		return businessIDsMap;
		
	}
}
