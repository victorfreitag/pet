package com.pet.controller;
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

import com.pet.DTO.PetDTO;
import com.pet.entities.Pet;
import com.pet.service.petService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pet")
public class petController {

	private final petService petService;

	@Autowired
	public petController(petService petservice) {
		this.petService = petservice;
	}
	@GetMapping("/{id}")
	public ResponseEntity<Pet> buscaPetControlId(@PathVariable Long id) {
		Pet pet = petService.buscarporId(id);
		if (pet != null) {
			return ResponseEntity.ok(pet);
		} else {
			return ResponseEntity.notFound().build();	}}
	
	@GetMapping
	public ResponseEntity<List<Pet>> buscaTodosPetControl() {
		List<Pet> Pet = petService.buscarTodos();
		return ResponseEntity.ok(Pet);
	}
	@PostMapping
	public ResponseEntity<PetDTO> criar(@RequestBody PetDTO petDTO) {
		PetDTO salvaPet = petService.salvar(petDTO);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaPet);
	}
	@PutMapping("/{id}")
	public ResponseEntity<PetDTO> alterar(@PathVariable Long id, @RequestBody @Valid PetDTO PetDTO) {
		PetDTO alteraPet = petService.atualizar(id, PetDTO);
		if (alteraPet != null) {
			return ResponseEntity.ok(PetDTO);
		} else {
			return ResponseEntity.notFound().build();}}

	@DeleteMapping("/{id}")
	public ResponseEntity<Pet> apagaPetControl(@PathVariable Long id) {
		boolean apagar = petService.deletar(id);
		if (apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.notFound().build();}}
}