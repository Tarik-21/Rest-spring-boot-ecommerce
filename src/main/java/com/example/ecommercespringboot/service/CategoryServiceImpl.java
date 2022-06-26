package com.example.ecommercespringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ecommercespringboot.dao.CategoryDAO;
import com.example.ecommercespringboot.entity.Category;

@Service
public class CategoryServiceImpl implements CategoryService{
	
    private CategoryDAO categoryDAO;
	
	@Autowired
	public CategoryServiceImpl(CategoryDAO theCategoryDAO) {
		categoryDAO = theCategoryDAO;
	}

	@Override
	public List<Category> findAll() {
	
		return categoryDAO.findAll();
	}

	@Override
	public Category findById(int theId) {
		return categoryDAO.findById(theId);
	}

	@Override
	public void save(Category theCategory) {

		categoryDAO.save(theCategory);
	}

	@Override
	public void deleteById(int theId) {
		categoryDAO.deleteById(theId);
	}

}
