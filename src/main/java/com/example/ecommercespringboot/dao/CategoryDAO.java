package com.example.ecommercespringboot.dao;

import java.util.List;

import com.example.ecommercespringboot.entity.Category;


public interface CategoryDAO {
	
    public List<Category> findAll();
	
	public Category findById(int theId);
	
	public void save(Category theCategory);
	
	public void deleteById(int theId);

}
