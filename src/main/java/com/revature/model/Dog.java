package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

@Component
@Entity
public class Dog implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column( name="dog_name")
	private String name;
	private String breed;
	private String gender;
	
	@Column( name="dog_age")
	private int age;
	
	@Column(name="dog_size")
	private String dogSize;
	private int weight;
	private String dogStatus;
	@Column(name="profile_comment")
	private String profileComment;
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private Owner ownerId;
	
	@Column(name="image_url")
	private String imageUrl;

	public Dog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dog(int id, String name, String breed, String gender, int age, String dogSize, int weight, String dogStatus,
			String profileComment, Owner ownerId, String imageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.dogSize = dogSize;
		this.weight = weight;
		this.dogStatus = dogStatus;
		this.profileComment = profileComment;
		this.ownerId = ownerId;
		this.imageUrl = imageUrl;
	}

	public Dog(String name, String breed, String gender, int age, String dogSize, int weight, String dogStatus,
			String profileComment, Owner ownerId, String imageUrl) {
		super();
		this.name = name;
		this.breed = breed;
		this.gender = gender;
		this.age = age;
		this.dogSize = dogSize;
		this.weight = weight;
		this.dogStatus = dogStatus;
		this.profileComment = profileComment;
		this.ownerId = ownerId;
		this.imageUrl = imageUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDogSize() {
		return dogSize;
	}

	public void setDogSize(String dogSize) {
		this.dogSize = dogSize;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getDogStatus() {
		return dogStatus;
	}

	public void setDogStatus(String dogStatus) {
		this.dogStatus = dogStatus;
	}

	public String getProfileComment() {
		return profileComment;
	}

	public void setProfileComment(String profileComment) {
		this.profileComment = profileComment;
	}

	public Owner getOwnerId() {
		return ownerId;
	}

	public void setOwnerId(Owner ownerId) {
		this.ownerId = ownerId;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, breed, dogSize, dogStatus, gender, id, imageUrl, name, ownerId, profileComment,
				weight);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dog other = (Dog) obj;
		return age == other.age && Objects.equals(breed, other.breed) && Objects.equals(dogSize, other.dogSize)
				&& Objects.equals(dogStatus, other.dogStatus) && Objects.equals(gender, other.gender) && id == other.id
				&& Objects.equals(imageUrl, other.imageUrl) && Objects.equals(name, other.name)
				&& Objects.equals(ownerId, other.ownerId) && Objects.equals(profileComment, other.profileComment)
				&& weight == other.weight;
	}

	@Override
	public String toString() {
		return "Dog [id=" + id + ", name=" + name + ", breed=" + breed + ", gender=" + gender + ", age=" + age
				+ ", dogSize=" + dogSize + ", weight=" + weight + ", dogStatus=" + dogStatus + ", profileComment="
				+ profileComment + ", ownerId=" + ownerId + ", imageUrl=" + imageUrl + "]";
	}


	
	
	


}
