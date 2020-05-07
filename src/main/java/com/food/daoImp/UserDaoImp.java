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
        String sql="select * from user where id=?";   
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
    
    public  User getUserById(String id){  
        String sql="select * from user where id=?";   
        final User user=new User("","");
        this.getJdbcTemplate().query(sql,new Object[] {id}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	user.setPassword(rs.getString("password"));
            	user.setName(rs.getString("name"));
            	user.setUser_id(rs.getString("id"));
            	
            }
           }
          );    
          System.out.println(user.getPassword());
          if(user.getUser_id().equals(id))return user;
          else return null;  
    } 
    
    public  void register(String phoneNum,String pass,String name){  
        String sql="insert into user(id,password,name) values(?,?,?)";  
        pass=encrypt(pass);
        this.getJdbcTemplate().update(sql, new Object[]{phoneNum,pass,name});
      }
	  
	public  void editPassword(String Id,String pass){  
        String sql="update user set password=? where id=?";  
        pass=encrypt(pass);
        this.getJdbcTemplate().update(sql, new Object[]{pass,Id});
      }  
	

    //1.查询img数据
    //alter table myuser drop column img;
    //alter table myuser add column img BLOB;
    public  String selectImg(String Id){  
        String sql="select img from user where id=?";   
        final User user=new User("","");
        this.getJdbcTemplate().query(sql,new Object[] {Id}, new RowCallbackHandler() {
            public void processRow(ResultSet rs) throws SQLException {
            	user.setName(rs.getString("img"));
            }
           }
          );  
        if(user.getName()==null) return "assets/images/products/myDefault.png";
        else return user.getName();  
    }  
    
    public  boolean IsExist(String phoneNum){  
        String sql="select * from user where id=?";   
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
	
	@Override
	public void updateUser(String condition, String data,String id) {
		// TODO Auto-generated method stub
		String sql="UPDATE user SET "+condition+"=?"+" WHERE id=?";  
        //pass=encrypt(pass);
        this.getJdbcTemplate().update(sql, new Object[]{data,id});   //18810449001鏀逛负褰撳墠鐧诲綍鐢ㄦ埛id
	}
	//get the number of users;
	public int GetUserListNumber() {
		// TODO Auto-generated method stub
		return 0;
	}
      
}  
