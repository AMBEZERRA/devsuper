package com.devsuper.devsuper.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuper.devsuper.dto.ProductDTO;
import com.devsuper.devsuper.entities.Product;
import com.devsuper.devsuper.repositories.ProductRepository;

// notação padrao identificando a camada de servico
@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	@Transactional(readOnly = true) // essa notacao é usada nesse momento para rapidez ja que nao estou salvando nada so consultando
	public ProductDTO findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;
		
	}

}
