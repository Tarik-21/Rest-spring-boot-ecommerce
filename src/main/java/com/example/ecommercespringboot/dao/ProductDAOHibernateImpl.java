package com.example.ecommercespringboot.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.ecommercespringboot.entity.Product;

@Repository
public class ProductDAOHibernateImpl implements ProductDAO {
	
	//define field for entitymanager
	
     private EntityManager entityManager;
		
     //set up constructor injection
	@Autowired public ProductDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Product> findAll() {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		//create a query
		Query<Product> theQuery = currentSession.createQuery("from Product",Product.class);
				
		//execute query and get result list
		List<Product> products = theQuery.getResultList();
				
				
		//return the reults
				
		return products;
	}

	@Override
	public Product findById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
				
		//get the employe
		Product theProduct = currentSession.get(Product.class, theId);
				
		//return the employee
		return theProduct;
	}

	@Override
	public void save(Product theProduct) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
						
		//save employee
		currentSession.saveOrUpdate(theProduct);

	}

	@Override
	public void deleteById(int theId) {
		//get current hibernate seesion
		Session currentSession = entityManager.unwrap(Session.class);
				
		//delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Product where id=:productsID");
		theQuery.setParameter("productsID", theId);
		theQuery.executeUpdate();

	}

	@Override
	public List<Product> findByIdCategory(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.createQuery("from Product where id_category=:id").setParameter("id", theId).list();
	}

	@Override
	public Product findByIdCateforyAndId(int idCategory, int idProduct) {
		Session currentSession = entityManager.unwrap(Session.class);
		return (Product) currentSession.createQuery("from Product where id_category=:idC and id_product=:idP").setParameter("idC", idCategory).setParameter("idP", idProduct).uniqueResult();
	}

}
