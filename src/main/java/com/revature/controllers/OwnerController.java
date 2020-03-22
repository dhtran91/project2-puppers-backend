package com.revature.controllers;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin
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
	   
	@PostMapping("/new")
	public ResponseEntity<String> createOwner(@RequestBody Owner o) {
		ownerService.createOwner(o);
		return new ResponseEntity<>("added owner "+o.getId(),HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<String> validateOwner(@RequestBody String email, String password) {
		Owner o1 = new Owner();
		List<Owner> owners = ownerService.getAllOwners();
		for(Owner o : owners) {
			if(o.getEmail() != null && o.getEmail().equals(email)) {
				if (o.getPassword() != null && o.getPassword().equals(password)) {
					o1 = o;
				return new ResponseEntity<>("owner logged in" + o1, HttpStatus.CREATED);
			}
				
			}
			
		}return new ResponseEntity<>("owner failed to login", HttpStatus.CREATED);

	} 
	
	@PutMapping("/update")
	public ResponseEntity<String> updateOwner(@RequestBody Owner o) {
		ownerService.updateOwner(o);
		return new ResponseEntity<>("updated owner " +o.getId(),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/owners")
	public void deleteOwner(@PathVariable("id")int id) {
		ownerService.deleteOwner(id);
	}
	
}
