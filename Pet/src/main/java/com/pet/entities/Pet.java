package com.pet.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Pet")
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@NotNull
	private String nome;
	
	@NotBlank
	@NotNull
	private String nascimento;
	
	@NotBlank
	@NotNull
	private String cudador;

	private String documento;

	public Pet(String nome,String nascimento,
 String cudador) {
		this.nome = nome;
		this.nascimento = nascimento;
		this.cudador = cudador;
	}

	
	
	
	
	

		
	
	
	
	
	

	
	
}