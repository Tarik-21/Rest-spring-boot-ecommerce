package com.example.ecommercespringboot.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommercespringboot.dao.ProductDAO;
import com.example.ecommercespringboot.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	private ProductDAO productDAO;
	
	@Autowired
	public ProductServiceImpl(ProductDAO theProductDAP) {
		productDAO = theProductDAP;
	}


	@Override
	@Transactional
	public List<Product> findAll() {
		return productDAO.findAll();
	}

	@Override
	@Transactional
	public Product findById(int theId) {
		return productDAO.findById(theId);
	}
	
	@Override
	@Transactional
	public List<Product> findByIdCategory(int theId) {
		return productDAO.findByIdCategory(theId);
	}

	@Override
	@Transactional
	public void save(Product theEmployee) {
		productDAO.save(theEmployee);
		
	}

	@Override
	@Transactional
	public void deleteById(int theId) {
		productDAO.deleteById(theId);
		
	}


	@Override
	public Product findByIdCateforyAndId(int idCategory, int idProduct) {
		return productDAO.findByIdCateforyAndId(idCategory, idProduct);
	}

}
