package com.devsuper.devsuper.dto;

import com.devsuper.devsuper.entities.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

	private Long id;
	
	@Size(min = 3, max = 80, message = "Nome deve ter entre 3 a 80 caracteres")
	@NotBlank(message = "Campo requerido") // verificar se o campo esta vazio e se deixou espaços em branco
	private String name;
	
	@Size(min = 10, message = "Descrição precisa ter no mínimo 10 caracter")
	@NotBlank(message = "Campo requerido")
	
	private String description;
	
	@Positive(message = "o preço tem que ser positivo")
	private Double price;
	private String imgUrl;

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}

	// contrutor alternativo para facilitar a camada de servico
	public ProductDTO(Product entity) {
		id = entity.getId();
		name = entity.getName();
		description = entity.getDescription();
		price = entity.getPrice();
		imgUrl = entity.getImgUrl();
	}

	// Não se cria SET em DTO ... pois não há a necessidade de alterar os dados
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public Double getPrice() {
		return price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

}
