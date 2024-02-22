package com.pet.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pet.DTO.PetDTO;
import com.pet.entities.Pet;
import com.pet.repository.petRepository;
@Service
public class petService {

	private final petRepository petRepository;

	@Autowired
	public petService(petRepository petRepository) {
		this.petRepository = petRepository;
	}
	public PetDTO salvar(PetDTO petDTO) {
		
		Pet pet = new Pet(petDTO.nome(),petDTO.nascimento(),petDTO.cuidador());
		Pet salvarPet = petRepository.save(pet);
		return new PetDTO(salvarPet.getId(),salvarPet.getNome(),salvarPet.getNascimento(),salvarPet.getCudador());
	}
		public PetDTO atualizar(Long id, PetDTO petDTO) {
			Pet existePet = petRepository.findById(id).orElseThrow(() -> new RuntimeException("Pet nao encontrado"));
			existePet.setNome(petDTO.nome());
			existePet.setNascimento(petDTO.nascimento());
			existePet.setCudador(petDTO.cuidador());
			
			Pet updatePet = petRepository.save(existePet);
			return new PetDTO(updatePet.getId(),updatePet.getNome(),updatePet.getNascimento(),updatePet.getCudador());
		}
		public boolean deletar(Long id) {
			Optional<Pet> existePet = petRepository.findById(id);
			if(existePet.isPresent()) {
				petRepository.deleteById(id);
				return true;
			}
			return false;
		}
		public List<Pet> buscarTodos(){
			return petRepository.findAll();
		}
		public Pet buscarporId(Long id) {
			Optional<Pet> pet = petRepository.findById(id);
			return pet.orElse(null);
		}
	
	}
