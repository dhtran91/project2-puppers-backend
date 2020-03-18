package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Dog;
import com.revature.model.Owner;
import com.revature.services.DogService;

@RestController
@RequestMapping("/dogs")
public class DogController {

	@Autowired
	DogService dogService;
	
	@GetMapping
	public List<Dog> getAllDogs(){
		return dogService.getAllDogs();
	}
	
	@GetMapping("{/id}")
	public Dog getDogById(@PathVariable("id")int id) {
		return dogService.getDogById(id);
	}
	
	@PostMapping
	public void createDog(@PathVariable("dog-name")String dogName,
			@PathVariable("dog-breed")String dogBreed,
			@PathVariable("dog-gender")String dogGender,
			@PathVariable("dog-age")int dogAge,
			@PathVariable("dog-size")String dogSize,
			@PathVariable("dog-weight")int dogWeight,
			@PathVariable("dog-behavior")String dogBehavior,
			@PathVariable("dog-owner-id")Owner dogOwnerId,
			@PathVariable("dog-image")String dogImage) {
		
		Dog d = new Dog(dogName, dogBreed, dogGender, dogAge, dogSize, dogWeight, dogBehavior, dogOwnerId, dogImage);
	}
	
	@PutMapping
	public void updateeDog(@PathVariable("id")int id,
			@PathVariable("dog-name")String dogName,
			@PathVariable("dog-breed")String dogBreed,
			@PathVariable("dog-gender")String dogGender,
			@PathVariable("dog-age")int dogAge,
			@PathVariable("dog-size")String dogSize,
			@PathVariable("dog-weight")int dogWeight,
			@PathVariable("dog-behavior")String dogBehavior,
			@PathVariable("dog-owner-id")Owner dogOwnerId,
			@PathVariable("dog-image")String dogImage) {
		
		Dog d = new Dog(id, dogName, dogBreed, dogGender, dogAge, dogSize, dogWeight, dogBehavior, dogOwnerId, dogImage);
		dogService.updateDog(d);
	}
	
	@DeleteMapping
	public void deleteDog(@PathVariable("id")int id) {
		dogService.deleteDog(id);
	}
	
}
