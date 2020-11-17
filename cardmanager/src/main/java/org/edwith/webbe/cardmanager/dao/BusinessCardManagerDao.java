package org.edwith.webbe.cardmanager.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.edwith.webbe.cardmanager.dto.BusinessCard;

public class BusinessCardManagerDao {
	
	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
		
	public BusinessCardManagerDao() {	
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "C##tester1";
		String password = "1234";

		try {
			Class.forName(driver);
			System.out.println("jdbc driver 로딩 성공");
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("오라클 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println("jdbc driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("오라클 연결 실패");
		}
		
	}
	
	//소멸자로 connection close 구현해주지 않아도 되나?
	
	
    public List<BusinessCard> searchBusinessCard(String keyword){
    	List<BusinessCard> Cards = new ArrayList<BusinessCard>();
    	String search_sql = 
        		"SELECT * FROM businesscard WHERE name LIKE ?";
        
    	try {
			ps = conn.prepareStatement(search_sql);
	    	ps.setString(1, "%"+keyword+"%");
	    	rs = ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		BusinessCard newCard = new BusinessCard(
	    				rs.getString("NAME"), rs.getString("PHONE"),
	    				rs.getString("COMPANYNAME"));
	    		newCard.setCreateDate(rs.getDate("CREATEDATE"));
	    		Cards.add(newCard);
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return Cards;    	
    }

    public void addBusinessCard(BusinessCard businessCard){
	// 원래는 BusinessCard를 return해주는데, return해줄 필요가 있는가??
    	String insert_sql = 
    		"INSERT INTO businesscard (name, phone, companyname, createdate) VALUES(?, ?, ?, ?)";
    	
    	try {
			ps = conn.prepareStatement(insert_sql);
			ps.setString(1, businessCard.getName());
	    	ps.setString(2, businessCard.getPhone());
			ps.setString(3, businessCard.getCompanyName());
	    	ps.setDate(4, new Date(businessCard.getCreateDate().getTime()));
	    				//java.util.Date 사용 -> sql.Date로 casting 해줘야함
	    	ps.executeUpdate();
	    	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}
