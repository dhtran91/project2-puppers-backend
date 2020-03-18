package com.revature.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Owner;
import com.revature.services.OwnerService;

@RestController
@RequestMapping("/owners")
public class OwnerController {

	@Autowired
	private OwnerService ownerService;
	
	@GetMapping
	public List<Owner> getAllOwners(){
		return ownerService.getAllOwners();
	}
	
	@GetMapping("/{id}")
	public Owner getOwnerById(@PathVariable("id")int id){
		return ownerService.getOwnerById(id);
	}
	
	@PostMapping
	public ResponseEntity<String> createOwner(@RequestBody Owner o) {
		ownerService.createOwner(o);
		return new ResponseEntity<>("added owner "+o.getId(),HttpStatus.CREATED);
	}

	@PutMapping("{id}")
	public void updateOwner(@PathVariable("id")int id,
			@PathVariable("first-name")String firstName,
			@PathVariable("last-name")String lastName,
			@PathVariable("email")String email,
			@PathVariable("password")String password,
			@PathVariable("address")String address,
			@PathVariable("postal-code")String postalCode) {
		
		Owner o = new Owner(id, firstName, lastName, email, password, address, postalCode);
		ownerService.updateOwner(o);
	}
	
	
	@DeleteMapping("/owners")
	public void deleteOwner(@PathVariable("id")int id) {
		ownerService.deleteOwner(id);
	}
	
}
