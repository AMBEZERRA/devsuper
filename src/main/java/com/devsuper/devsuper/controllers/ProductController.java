package com.devsuper.devsuper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/{id}") // mapeou a rota do products // buscando por id
	public ProductDTO findById(@PathVariable Long id) { 
		ProductDTO dto = service.findById(id);
		return dto;
	}
	
	@GetMapping  // mapeou a rota do productsO // buscando a lista de produtos por paginas
	public Page<ProductDTO> findAll(Pageable pageable) {  // o argumento dentro do método fará a busca por páginas
		return service.findAll(pageable);
		
	}
	
	// Metodo para inserir no formato JSON // se ligue na anotation
	@PostMapping  // mapeou a rota para inserir
	public ProductDTO insert(@RequestBody ProductDTO dto) {  
		dto = service.insert(dto);
		return dto;
		
	}
}
