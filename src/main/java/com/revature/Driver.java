package com.revature;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;

import com.revature.dao.DogDao;
import com.revature.dao.OwnerDao;
import com.revature.model.Dog;
import com.revature.model.Owner;
import com.revature.services.OwnerService;

public class Driver {
	OwnerService s = new OwnerService();
	public static void main(String[] args) {
	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	OwnerDao ownerDao = (OwnerDao) ac.getBean("ownerDaoImpl");
	DogDao dogDao = (DogDao) ac.getBean("dogDaoImpl");
		String email = "jay@gmail.com";
		String password ="password";
		Owner o1 = new Owner();
		List<Owner> owners = ownerDao.getAllOwner();
		for(Owner o : owners) {
			if(o.getEmail() != null && o.getEmail().equals(email)) {
				if (o.getPassword() != null && o.getPassword().equals(password)) {
				 o1 =o;
				 System.out.println(o1);
			}
				
			}
			
		}
	}

}
