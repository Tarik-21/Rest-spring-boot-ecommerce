package com.example.ecommercespringboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommercespringboot.dao.AdminDAO;
import com.example.ecommercespringboot.dao.ProductDAO;
import com.example.ecommercespringboot.entity.Admin;

@Service
public class AdminServiceImpl implements AdminService {
	
    private AdminDAO adminDAO;
	
	@Autowired
	public AdminServiceImpl(AdminDAO theAdminDAO) {
		adminDAO = theAdminDAO;
	}

	@Override
	@Transactional
	public Admin findByEmail(String email) {
		return adminDAO.findByEmail(email);
	}

}
