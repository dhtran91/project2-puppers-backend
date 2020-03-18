package com.revature;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.DogDao;
import com.revature.dao.OwnerDao;
import com.revature.model.Dog;
import com.revature.model.Owner;

public class Driver {

	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	OwnerDao ownerDao = (OwnerDao) ac.getBean("ownerDaoImpl");
	DogDao dogDao = (DogDao) ac.getBean("dogDaoImpl");
//	
//	Owner o = new Owner();
//	o.setFirstName("Jay");
//	o.setLastName("Boucher");
//	o.setEmail("jay@gmail.com");
//	o.setPassword("password");
//	o.setAddress("110 abc lane");
//	o.setPostalCode("75019");
//	
//	ownerDao.createOwner(o);
//	
//	Owner o1 = ownerDao.getById(1);
//	System.out.println(o1);
	
	Dog d = new Dog();
	d.setName("Ralph");
	d.setAge(2);
	d.setBreed("Retriever");
	d.setDogSize("large");
	d.setDogStatus("Single");
	d.setGender("Male");
	d.setImageUrl("url");
	d.setProfileComment("Happy");
	d.setWeight(120);
	d.setOwnerId(ownerDao.getById(1));
	
	dogDao.createDog(d);
	
	Dog d1 = dogDao.getById(1);
	System.out.println(d1);

	}

}
