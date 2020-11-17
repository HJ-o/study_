package org.edwith.webbe.guestbook.util;

import java.sql.*;

public class DBUtil {
    public static Connection getConnection(){
    	

		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##tester1";
		String password = "1234";
    	
    	
        // 본인 database에 맞게끔 수정해주세요.
        return getConnection(driver, url, user, password);
    }

    public static Connection getConnection(String driver, String dbURL, String dbId, String dbPassword){
        Connection conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(dbURL, dbId, dbPassword);
            return conn;
        }catch(Exception ex){
            throw new RuntimeException("Connection Error");
        }
    }
}
