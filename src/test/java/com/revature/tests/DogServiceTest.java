package com.revature.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.model.Dog;
import com.revature.model.Owner;
import com.revature.services.DogService;
import com.revature.services.OwnerService;



public class DogServiceTest {

	ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
	private DogService dogService = (DogService) ac.getBean("dogService");
	private OwnerService ownerService = (OwnerService) ac.getBean("ownerService");
	
	@Test
	public void testCreateDog() {
		Owner o = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(o);
		Dog expected = new Dog(1, "Ralph", "Retriever", "Male", 2, "large", 120, "Single", "Happy", o, "url");
		dogService.createDog(expected);
		Dog test = dogService.getDogById(1);
		assertEquals(expected, test);
		
	}
	
	@Test
	public void testDeleteDogById() {
		Owner o = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(o);
		Dog expected = new Dog(1, "Ralph", "Retriever", "Male", 2, "large", 120, "Single", "Happy", o, "url");
		dogService.createDog(expected);
		dogService.deleteDog(1);
		Dog test = dogService.getDogById(1);
		assertNull(test);
		
	}
	
	@Test
	public void testGetDogById() {
		Owner o = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(o);
		Dog expected = new Dog(1, "Ralph", "Retriever", "Male", 2, "large", 120, "Single", "Happy", o, "url");
		dogService.createDog(expected);
		Dog test = dogService.getDogById(1);
		assertEquals(expected, test);
		
	}
	
	@Test
	public void testUpdateDog() {
		Owner o = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019");
		ownerService.createOwner(o);
		Dog expected = new Dog(1, "Ralph", "Retriever", "Male", 2, "large", 120, "Single", "Happy", o, "url");
		dogService.createDog(expected);
		expected.setAge(3);
		dogService.updateDog(expected);
		Dog test = dogService.getDogById(1);
		assertEquals(expected, test);
		
	}
}
