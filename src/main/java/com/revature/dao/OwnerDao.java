package com.revature.dao;

import org.springframework.stereotype.Repository;

import com.revature.model.Owner;


public interface OwnerDao {

	public Owner getById(int id);

}
