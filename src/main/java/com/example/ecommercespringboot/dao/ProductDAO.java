package com.example.ecommercespringboot.dao;

import java.util.List;

import com.example.ecommercespringboot.entity.Product;


public interface ProductDAO {
	
    public List<Product> findAll();
	
	public Product findById(int theId);
	
	public List<Product> findByIdCategory(int theId);
	
	public Product findByIdCateforyAndId(int idCategory,int idProduct);
	
	public void save(Product theProduct);
	
	public void deleteById(int theId);
	

}
