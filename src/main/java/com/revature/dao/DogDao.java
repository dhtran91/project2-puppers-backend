package com.revature.dao;

import java.util.List;

import com.revature.model.Dog;


public interface DogDao {

	public Dog getById(int id);
	
	public void createDog(Dog d);
	
	public void updateDog(Dog d);
	
	public void deleteDog(int id);
	
	public List<Dog> getAllDog();

}
