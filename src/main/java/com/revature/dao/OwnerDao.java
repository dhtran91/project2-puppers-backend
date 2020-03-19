package com.revature.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.revature.model.Owner;


public interface OwnerDao {

	public Owner getById(int id);
	
	public void createOwner(Owner o);
	
	public void updateOwner(Owner o);
	
	public void deleteOwner(int id);
	
	public List<Owner> getAllOwner();
	

}
