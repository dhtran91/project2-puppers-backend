package com.revature.dao;

import java.util.List;

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
	
	@Transactional
	@Override
	public Owner getById(int id) {
		Session s = sf.getCurrentSession();
		Owner o = (Owner) s.get(Owner.class, id);
		return o;
	}

	@Transactional
	@Override
	public void createOwner(Owner o) {
		Session s = sf.getCurrentSession();
		s.save(o);
	}

	@Transactional
	@Override
	public void updateOwner(Owner o) {
		sf.getCurrentSession().update(o);
	}

	@Transactional
	@Override
	public void deleteOwner(int id) {
		Session s = sf.getCurrentSession();
		Owner o = (Owner) s.get(Owner.class, id);
		sf.getCurrentSession().delete(o);
	}

	@Transactional
	@Override
	public List<Owner> getAllOwner() {
		Session s = sf.getCurrentSession();
		List<Owner> o = s.createQuery("from Owner").list();
		return o;
	}
	

	

}
