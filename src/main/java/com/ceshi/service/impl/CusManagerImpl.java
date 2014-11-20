package com.ceshi.service.impl;

import java.util.List;

import com.ceshi.dao.CusDAO;
import com.ceshi.model.Customer;
import com.ceshi.service.ICusManager;



public class CusManagerImpl implements ICusManager {

	CusDAO cusDao;
	

	public CusDAO getCusDao() {
		return cusDao;
	}

	public void setCusDao(CusDAO cusDao) {
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
