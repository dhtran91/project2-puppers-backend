package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.OwnerDao;
import com.revature.model.Owner;

@Service
public class OwnerService {
	
	@Autowired
	OwnerDao ownerDao;
	
	public List<Owner> getAllOwners(){
		return ownerDao.getAllOwner();
	}
	
	public Owner getOwnerById(int id) {
		return ownerDao.getById(id);
	}
	
	public void createOwner(Owner o) {
		ownerDao.createOwner(o);
	}
	
	public void updateOwner(Owner o) {
		ownerDao.updateOwner(o);
	}
	
	public void deleteOwner(int id) {
		ownerDao.deleteOwner(id);
	}
	
	
}
