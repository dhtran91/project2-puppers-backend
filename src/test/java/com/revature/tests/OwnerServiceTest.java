package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.revature.model.Owner;
import com.revature.services.OwnerService;

public class OwnerServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	private OwnerService ownerService = (OwnerService) ac.getBean("ownerService");
	
	@Test
	public void TestCreateOwner() {
		
		Owner expected = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(expected);
		Owner test = ownerService.getOwnerById(1);
		assertEquals(expected, test);
	}
	
	@Test
	public void TestDeleteById() {
		Owner expected = new Owner(1, "John", "Smith", "js@gmail.com", "password", "111 abc lane", "75019");
		Owner test = ownerService.getOwnerById(1);
		assertNull(test);
	}
	
	@Test
	public void TestGetOwnerById() {
		
		Owner expected = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		Owner expected2 = new Owner(1, "John", "Smith", "js@gmail.com", "password", "111 abc lane", "75019");
		ownerService.createOwner(expected);
		ownerService.createOwner(expected2);
		Owner test = ownerService.getOwnerById(1);
		assertEquals(expected, test);
	}
	
	@Test
	public void TestUpdateOwner() {
		
		Owner expected = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(expected);
		expected.setPassword("pass123");
		ownerService.updateOwner(expected);
		Owner test = ownerService.getOwnerById(1);
		assertEquals(expected, test);
	}
	
}
