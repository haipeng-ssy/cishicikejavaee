package com.ceshi.service.implInterface;

import java.util.List;

import com.ceshi.hibernate.CusHibernate;
import com.ceshi.interace.ICusManager;
import com.ceshi.model.Customer;



public class CusManagerImpl implements ICusManager {

	CusHibernate cusDao;
	

	public CusHibernate getCusDao() {
		return cusDao;
	}

	public void setCusDao(CusHibernate cusDao) {
		this.cusDao = cusDao;
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
		cusDao.save(customer);	
	}

	@Override
	public void deleteCus(Customer customer) {
		// TODO Auto-generated method stub		
		cusDao.delete(customer);
	}




}
