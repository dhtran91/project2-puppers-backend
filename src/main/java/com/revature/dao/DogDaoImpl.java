package com.revature.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Dog;
import com.revature.model.Owner;

@Repository
public class DogDaoImpl implements DogDao{

	@Autowired
	private SessionFactory sf;
	
	@Transactional
	@Override
	public Dog getById(int id) {
		Session s = sf.getCurrentSession();
		Dog d = (Dog) s.get(Dog.class, id);
		return d;
	}

	@Transactional
	@Override
	public void createDog(Dog d) {
		Session s = sf.getCurrentSession();
		s.save(d);
	}

	@Transactional
	@Override
	public void updateDog(Dog d) {
		sf.getCurrentSession().update(d);
		
	}

	@Transactional
	@Override
	public void deleteDog(int id) {
		Session s = sf.getCurrentSession();
		Dog d = (Dog) s.get(Dog.class, id);
		sf.getCurrentSession().delete(d);
		
	}

	@Transactional
	@Override
	public List<Dog> getAllDog() {
		Session s = sf.getCurrentSession();
		List<Dog> d = s.createQuery("from Dog").list();
		return d;
	}



}
