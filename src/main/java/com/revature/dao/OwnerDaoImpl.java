package com.revature.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.revature.model.Owner;

@Repository
public class OwnerDaoImpl implements OwnerDao {
	
	@Autowired
	private SessionFactory sf;
	


	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public Owner getById(int id) {
		Session s = sf.getCurrentSession();
		Owner o = (Owner) s.get(Owner.class, id);
		return o;
	}

}
