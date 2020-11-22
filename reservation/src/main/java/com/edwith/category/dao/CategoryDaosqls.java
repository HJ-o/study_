package com.edwith.category.dao;

public class CategoryDaosqls {
	public static final String SELECT_ALL = "SELECT id, name FROM category order by id";
	public static final String SELECT_COUNT = "SELECT category.id, name, count FROM category JOIN (SELECT category_id as id, count(display_info.id) as count FROM product JOIN display_info ON product.id = display_info.product_id GROUP BY product.category_id) as count on category.id = count.id order by category.id";
	
}
