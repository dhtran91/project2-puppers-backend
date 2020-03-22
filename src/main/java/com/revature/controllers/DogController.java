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

import com.revature.model.Dog;
import com.revature.services.DogService;

@CrossOrigin
@RestController
@RequestMapping("/dogs")
public class DogController {

	@Autowired
	DogService dogService;
	
	@GetMapping
	public List<Dog> getAllDogs(){
		return dogService.getAllDogs();
	}
	
	@GetMapping("/{id}")
	public Dog getDogById(@PathVariable("id")int id) {
		return dogService.getDogById(id);
	}
		
	@PostMapping("/new")
	public ResponseEntity<String> createDog(@RequestBody Dog d) {
		dogService.createDog(d);
		return new ResponseEntity<>("added dog "+d.getName(),HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<String> updateDog(@RequestBody Dog d) {
		dogService.updateDog(d);
		return new ResponseEntity<>("updated dog " +d.getId(),HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public void deleteDog(@PathVariable("id")int id) {
		dogService.deleteDog(id);
	}
	
}
