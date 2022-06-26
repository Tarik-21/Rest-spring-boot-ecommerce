package com.example.ecommercespringboot.service;

import com.example.ecommercespringboot.entity.Admin;

public interface AdminService {
	public Admin findByEmail(String email);

}
