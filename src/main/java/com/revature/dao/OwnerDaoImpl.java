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

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public void createOwner(Owner o) {
		sf.getCurrentSession().save(o);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public void updateOwner(Owner o) {
		sf.getCurrentSession().update(o);
	}

	@Transactional(propagation=Propagation.SUPPORTS)
	@Override
	public void deleteOwner(Owner o) {
		sf.getCurrentSession().delete(o);
	}
	

	

}
