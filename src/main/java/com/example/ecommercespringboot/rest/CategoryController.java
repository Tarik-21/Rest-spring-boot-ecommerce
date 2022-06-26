package com.example.ecommercespringboot.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ecommercespringboot.entity.Category;
import com.example.ecommercespringboot.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api")
public class CategoryController {
	
	private CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService theCategoryService) {
		categoryService = theCategoryService;
	}
	
	@GetMapping("/categories")
	public List<Category> findAllCategories(){
		return categoryService.findAll();
	}

}
