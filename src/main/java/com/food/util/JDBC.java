package com.food.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class JDBC {

	/**
	 * Get connection to mysql-online_restaurant.
	 * @return Connection object
	 */
	public static Connection getConnectionon() {

        Connection conn = null;
        try(FileInputStream f = new FileInputStream("./property/online_restaurant.properties")) {

            // load the properties file
            Properties pros = new Properties();
            pros.load(f);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
	 
	
	/**
	 * Close connection to database.
	 */
	public static void closeConnection(Connection conn){
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

	
    /**
     * Close callable statement.
     */
    public static void closeCallableStatement(CallableStatement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Close prepared statement.
     */
    public static void closePreparedStatement(PreparedStatement pstmt) {
        if(pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    
    /**
     * Close result set.
     */
    public static void closeResultSet(ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
