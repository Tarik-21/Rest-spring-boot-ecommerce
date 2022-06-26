package com.example.ecommercespringboot.dao;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommercespringboot.entity.Admin;
import com.example.ecommercespringboot.entity.Category;


@Repository
public class AdminDAOHibernateImpl implements AdminDAO {
	private EntityManager entityManager;
	
	@Autowired public AdminDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}


	@Override
	public Admin findByEmail(String email) {
		Session currentSession = entityManager.unwrap(Session.class);
		return (Admin) currentSession.createQuery("from Admin where email=:email").setParameter("email", email).uniqueResult();
	}

}
