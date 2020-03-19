package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.dao.DogDao;
import com.revature.model.Dog;


@Service
public class DogService {
	
	@Autowired
	DogDao dogDao;
	
	public List<Dog> getAllDogs(){
		return dogDao.getAllDog();
	}
	
	public Dog getDogById(int id) {
		return dogDao.getById(id);
	}
	
	public void createDog(Dog d) {
		dogDao.createDog(d);
	}
	
	public void updateDog(Dog d) {
		dogDao.updateDog(d);
	}
	
	public void deleteDog(int id) {
		dogDao.deleteDog(id);
	}
}
