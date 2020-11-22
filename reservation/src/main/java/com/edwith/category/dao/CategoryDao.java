package com.edwith.category.dao;

import static com.edwith.category.dao.CategoryDaosqls.SELECT_ALL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.edwith.category.dto.Categories;
import com.edwith.category.dto.Category;

import static com.edwith.category.dao.CategoryDaosqls.*;

@Repository
public class CategoryDao {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Category> rowMapper = BeanPropertyRowMapper.newInstance(Category.class);
	private RowMapper<Categories> rowMapper_count = BeanPropertyRowMapper.newInstance(Categories.class);
	
	public List<Category> selectAll(){
		return jdbc.query(SELECT_ALL, rowMapper);
	}
	
	public List<Categories> selectAll_Count(){
		return jdbc.query(SELECT_COUNT, rowMapper_count);
	}
}
