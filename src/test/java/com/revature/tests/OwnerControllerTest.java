package com.revature.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.revature.controllers.OwnerController;
import com.revature.model.Owner;
import com.revature.services.OwnerService;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class OwnerControllerTest {
	
	@Autowired
	private OwnerController ownerController;
	
	@Test
	public void testGetOwnerByIdValid() {
		Owner result = ownerController.getOwnerById(1);
		Owner expected = new Owner(1, "Jay", "Boucher", "jay@gmail.com", "password", "110 abc lane", "75019" );

		assertNotNull(result);
		
		System.out.println("this is expected: " + expected);
		System.out.println("this is test: " + result);
	}
	
}
