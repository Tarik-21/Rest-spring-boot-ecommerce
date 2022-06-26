package com.example.ecommercespringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommercespringboot.entity.Category;
import com.example.ecommercespringboot.entity.Product;

@Repository
public class CategoryDAOHibernateImpl implements CategoryDAO {
	//define field for entitymanager
	
    private EntityManager entityManager;
		
    //set up constructor injection
	@Autowired public CategoryDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Category> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		//create a query
		Query<Category> theQuery = currentSession.createQuery("from Category",Category.class);
						
		//execute query and get result list
		List<Category> categories = theQuery.getResultList();
						
						
		//return the reults
						
		return categories;
	}

	@Override
	public Category findById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
						
		//get the employe
		Category theCategory = currentSession.get(Category.class, theId);
						
		//return the employee
		return theCategory;
	}

	@Override
	public void save(Category theCategory) {
		///get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		//save employee
		currentSession.saveOrUpdate(theCategory);

	}

	@Override
	public void deleteById(int theId) {
		//get current hibernate seesion
		Session currentSession = entityManager.unwrap(Session.class);
						
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from categories where id=:categoriesId");
		theQuery.setParameter("categoriesId", theId);
		theQuery.executeUpdate();

	}

}
