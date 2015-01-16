package com.ceshi.service.impl;

import java.util.List;

import com.ceshi.hibernate.CusHibernate;
import com.ceshi.interace.ICusManager;
import com.ceshi.model.Customer;



public class CusManagerImpl implements ICusManager {

	CusHibernate cusHibernate;
	

	public CusHibernate getcusHibernate() {
		return cusHibernate;
	}

	public void setcusHibernate(CusHibernate cusHibernate) {
		this.cusHibernate = cusHibernate;
	}

	/*	@Override
	public List queryAll() {
		// TODO Auto-generated method stub
		return null;
	}
*/
	@Override
	public void insertCus(Customer customer) {
		// TODO Auto-generated method stub
		cusHibernate.save(customer);	
	}

	@Override
	public void deleteCus(Customer customer) {
		// TODO Auto-generated method stub		
		cusHibernate.delete(customer);
	}




}
