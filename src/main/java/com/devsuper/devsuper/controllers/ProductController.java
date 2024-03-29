package com.devsuper.devsuper.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.devsuper.devsuper.dto.ProductDTO;
import com.devsuper.devsuper.services.ProductService;

import jakarta.validation.Valid;

// o que for implementado nessa classe vai responder via web
@RestController
@RequestMapping(value = "/products") // responde via web nessa rota
public class ProductController {
	
	@Autowired // Injeção de dependencia 
	private ProductService service;

	/*@GetMapping(value = "/{id}") // mapeou a rota do products // buscando por id
	public ProductDTO findById(@PathVariable Long id) { 
		ProductDTO dto = service.findById(id);
		return dto;
	} */
	
	// Configurando para obter a resposta através do ResponseEntity
	
	@GetMapping(value = "/{id}") // mapeou a rota do products // buscando por id
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) { 
		ProductDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	/*@GetMapping  // mapeou a rota do productsO // buscando a lista de produtos por paginas
	public Page<ProductDTO> findAll(Pageable pageable) {  // o argumento dentro do método fará a busca por páginas
		return service.findAll(pageable);
		
	}*/
	
	@GetMapping  // mapeou a rota do productsO // buscando a lista de produtos por paginas
	public ResponseEntity<Page<ProductDTO>> findAll(Pageable pageable) {  // o argumento dentro do método fará a busca por páginas
		Page<ProductDTO> dto = service.findAll(pageable);
		return ResponseEntity.ok(dto);
		
	}
	
	
	/*
	// Metodo para inserir no formato JSON // se ligue na anotation
	@PostMapping  // mapeou a rota para inserir
	public ProductDTO insert(@RequestBody ProductDTO dto) {  
		dto = service.insert(dto);
		return dto;
	}
	*/
	
	@PostMapping  // mapeou a rota para inserir
	public ResponseEntity<ProductDTO> insert(@Valid @RequestBody ProductDTO dto) {  
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto); // alem de mostrar o código 201 informará o link do obj criado
	}
	
	@PutMapping(value = "/{id}") // mapeou a rota do products // buscando por id
	public ResponseEntity<ProductDTO> update(@PathVariable Long id, @Valid @RequestBody ProductDTO dto ) { 
		dto = service.update(id, dto);
		return ResponseEntity.ok(dto);
	}
	
	@DeleteMapping(value = "/{id}") // mapeou a rota do products // buscando por id
	public ResponseEntity<Void> delete(@PathVariable Long id) { 
		service.delete(id);
		return ResponseEntity.noContent().build(); // respondendo 204 deu certo e nao tem corpo
		
	}
}
