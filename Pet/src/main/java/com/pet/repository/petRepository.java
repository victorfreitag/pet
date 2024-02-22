package com.pet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.entities.Pet;

public interface petRepository extends JpaRepository<Pet, Long> {
	
	
}