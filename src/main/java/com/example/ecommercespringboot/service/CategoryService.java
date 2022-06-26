package com.example.ecommercespringboot.service;

import java.util.List;

import com.example.ecommercespringboot.entity.Category;


public interface CategoryService {
	
    public List<Category> findAll();
	
	public Category findById(int theId);
	
	public void save(Category theCategory);
	
	public void deleteById(int theId);

}
