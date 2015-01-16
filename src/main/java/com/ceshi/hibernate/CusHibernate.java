package com.ceshi.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ceshi.model.Customer;



public class CusHibernate {

	private SessionFactory sessionFactory;

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Customer customer){
		try {
			Session session=getSession();
				session.save(customer);
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public void delete(Customer customer){
		try {
			Session session = getSession();
			session.delete(customer);
			
		} catch (Exception e) {
			// TODO: handle exception
		    e.printStackTrace();
		    
		} 
		
	}
	/*public List queryAll(){
		try {
			Session session = getSession();
			session.get(Customer.class,Customer.serialVersionUID);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}*/
	
	
}
