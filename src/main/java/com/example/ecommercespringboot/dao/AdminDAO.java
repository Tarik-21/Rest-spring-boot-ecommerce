package com.example.ecommercespringboot.dao;

import com.example.ecommercespringboot.entity.Admin;

public interface AdminDAO {
	
	public Admin findByEmail(String email);

}
