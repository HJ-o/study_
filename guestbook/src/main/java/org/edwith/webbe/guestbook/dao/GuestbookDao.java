package org.edwith.webbe.guestbook.dao;

import org.edwith.webbe.guestbook.dto.Guestbook;
import org.edwith.webbe.guestbook.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class GuestbookDao {
	
	Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
		
	public GuestbookDao() {	
		conn = DBUtil.getConnection();
	}
	
    public List<Guestbook> getGuestbooks(){
        List<Guestbook> list = new ArrayList<>();

    	String search_sql = 
        		"SELECT * FROM guestbook";
    	try {
			ps = conn.prepareStatement(search_sql);
	    	rs = ps.executeQuery();
	    	
	    	while(rs.next()) {
	    		Guestbook newbook = new Guestbook(
	    				rs.getLong("ID"), rs.getString("NAME"),
	    				rs.getString("CONTENT"), rs.getDate("REGDATE"));
	    		list.add(newbook);
	    	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;    
    }

    public void addGuestbook(Guestbook guestbook){
    	
    	String insert_sql = 
        		"INSERT INTO guestbook (id, name, content, regdate) VALUES(tmp_seq.NEXTVAL, ?, ?, ?)";
        	
        	try {
    			ps = conn.prepareStatement(insert_sql);
    	    	ps.setString(1, guestbook.getName());
    			ps.setString(2, guestbook.getContent());
    			ps.setDate(3, new Date(guestbook.getRegdate().getTime()));
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
