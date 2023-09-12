package com.devsuper.devsuper.dto;

import com.devsuper.devsuper.entities.Product;

public class ProductDTO {
	
	private Long id;
	private String name;
	private String description;
	private Double price;
	private String imgUrl;
	
	public ProductDTO() {
		
	}

	public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.imgUrl = imgUrl;
	}
	
	// contrutorr alternativo para facilitar a camda de servico
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
