package com.edwith.category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edwith.category.dao.CategoryDao;
import com.edwith.category.dto.Categories;
import com.edwith.category.dto.Category;

@Service
public class CategoryService {

	@Autowired
	CategoryDao categoryDao;
	
	public List<Category> getCategory() {
		return categoryDao.selectAll();
	}

	public List<Categories> getCategories() {
		return categoryDao.selectAll_Count();
	}
}
