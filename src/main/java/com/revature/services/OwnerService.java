package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

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
	
//	public Owner validateOwner(String email, String password) {
//		List<Owner> owners = ownerDao.getAllOwner();
//		Owner o1 = new Owner();
//		for(Owner o : owners) {
//			if(o.getEmail() != null && o.getEmail().equals(email)) {
//				if (o.getPassword() != null && o.getPassword().equals(password)) {
//					o1 = o;
//				return o1;
//			}
//				
//			}
//			
//		}return null;
//
//	} 
//	
}
