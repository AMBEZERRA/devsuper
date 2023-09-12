package com.devsuper.devsuper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuper.devsuper.dto.ProductDTO;
import com.devsuper.devsuper.services.ProductService;

// o que for implementado nessa classe vai responder via web
@RestController
@RequestMapping(value = "/products") // responde via web nessa rota
public class ProductController {
	
	@Autowired // Injeção de dependencia 
	private ProductService service;

	@GetMapping(value = "/{id}") // mapeou a rota do productsO
	public ProductDTO findById(@PathVariable Long id) { 
		ProductDTO dto = service.findById(id);
		return dto;
	}
}
