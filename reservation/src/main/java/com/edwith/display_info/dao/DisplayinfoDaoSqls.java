package com.edwith.display_info.dao;

public class DisplayinfoDaoSqls {
	public static final String SELECT_by_ID = 
			"SELECT p.id as product_id, category_id, d.id as displayinfo_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, d.create_date as create_date, d.modify_date as modify_date" +
			" FROM product p" + 
			" LEFT  JOIN category c ON  c.id = p.category_id" + 
			" RIGHT JOIN display_info d ON p.id = d.product_id" + 
			" WHERE category_id = :id" + 
			" ORDER by p.id";
	
	public static final String SELECTAll = 
			"SELECT p.id as product_id, category_id, d.id as displayinfo_id, name, description, content, event, opening_hours, place_name, place_lot, place_street, tel, homepage, email, d.create_date as create_date, d.modify_date as modify_date" +
			" FROM product p" + 
			" LEFT  JOIN category c ON  c.id = p.category_id" + 
			" RIGHT JOIN display_info d ON p.id = d.product_id" + 
			" ORDER by p.id";
	
	public static final String SELECT_COUNT_PRODUCT =
			"SELECT count(id) FROM product";
	
	public static final String SELECT_COUNT_PRODUCT_by_ID =
			"SELECT count(id) FROM product WHERE category_id = :id";
}
