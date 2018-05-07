package com.food.daoImp;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.food.dao.UserDao;
import com.food.model.User;

public class UserDaoImp extends JdbcDaoSupport implements UserDao{  
	public UserDaoImp() { super();  }  
    public  User login(String phoneNum,String pass){  
        String sql="select * from myuser where id=?";   
        final User user=new User("","");
        this.getJdbcTemplate().query(sql,new Object[] {phoneNum}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	user.setPassword(rs.getString("password"));
            	user.setName(rs.getString("name"));
            	user.setUser_id(rs.getString("id"));
            }
           }
          );    
          System.out.println(user.getPassword());
          if(user.getPassword().equals(encrypt(pass)))return user;
          else return null;  
    }  
    
    public  void register(String phoneNum,String pass,String name){  
        String sql="insert into myuser(id,password,name) values(?,?,?)";  
        pass=encrypt(pass);
        this.getJdbcTemplate().update(sql, new Object[]{phoneNum,pass,name});
      }
    
    public  boolean IsExist(String phoneNum){  
        String sql="select * from myuser where id=?";   
        final User user=new User("","");
        this.getJdbcTemplate().query(sql,new Object[] {phoneNum}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	user.setPassword(rs.getString("password"));
            }
           }
          );   
          System.out.println("the pass is"+user.getPassword());
          if(user.getPassword().equals(""))return false;
          else return true;
      }
    
    public String encrypt(String key){
    	MessageDigest digest;
    	String hexstring="";
		try {
			digest = MessageDigest.getInstance("MD5");
			digest.update(key.getBytes());
	    	byte[] bytes = digest.digest(key.getBytes());
	    	StringBuilder sb = new StringBuilder();
	    	for (int i = 0; i < bytes.length; i++) {
	    	 String hex = Integer.toHexString(bytes[i]&0xff);
	    	 if (hex.length() == 1){
	    	 sb.append("0");
	    	 }
	    	 sb.append(hex);
	    	}
	    	hexstring = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hexstring;
    }
      
}  
