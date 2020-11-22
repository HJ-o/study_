package com.edwith.category.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edwith.category.dto.Categories;
import com.edwith.category.service.CategoryService;

@RestController
@RequestMapping(path="/api/categories")
public class CategoryController {
//카테고리 목록 구하기
	
	@Autowired
	CategoryService categoryService;
	
	
	@GetMapping
	public Map<String, Object> getCategories(){
		List<Categories> category = categoryService.getCategories();
		Map<String, Object> map = new HashMap<>();
		map.put("size", category.size());
		map.put("items", category);
		return map;
	}
	
}
