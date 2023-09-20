package com.devsuper.devsuper.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	// metodo para buscar um elmento do banco pelo id (product)
	@Transactional(readOnly = true) // essa notacao é usada nesse momento para rapidez ja que nao estou salvando
									// nada so consultando
	public ProductDTO findById(Long id) {
		Optional<Product> result = repository.findById(id);
		Product product = result.get();
		ProductDTO dto = new ProductDTO(product);
		return dto;

	}

	// metodo para retornar uma lista de elemento do banco (pproduct)
	@Transactional(readOnly = true) // essa notacao é usada nesse momento para rapidez ja que nao estou salvando
									// nada so consultando
	public Page<ProductDTO> findAll(Pageable pageable) {
		Page<Product> result = repository.findAll(pageable); // page tipo especial de LIST
		return result.map(x -> new ProductDTO(x)); // expressão lambda

	}

	/*
	 * // Criando o metodo de incluir e salvar no DB (Método Padrão)
	 * 
	 * @Transactional public ProductDTO insert(ProductDTO dto) { Product entity =
	 * new Product(); entity.setName(dto.getName());
	 * entity.setDescription(dto.getDescription()); entity.setPrice(dto.getPrice());
	 * entity.setImgUrl(dto.getImgUrl());
	 * 
	 * entity = repository.save(entity); // chamando a classe repository pra salvar
	 * no DB return new ProductDTO(entity);
	 * 
	 * }
	 */

	// Criando o metodo de incluir e salvar no DB (Método auxiliar sendo usado: boas
	// práticas)
	@Transactional
	public ProductDTO insert(ProductDTO dto) {
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity); // chamando a classe repository pra salvar no DB
		return new ProductDTO(entity);

	}

	/*
	 * // UPDATE atualizando um produto (Método Padrão)
	 * 
	 * @Transactional public ProductDTO update(Long id, ProductDTO dto) {
	 * 
	 * Product entity = repository.getReferenceById(id); //instanciando um produto
	 * com a referencia do Id informado entity.setName(dto.getName());
	 * entity.setDescription(dto.getDescription()); entity.setPrice(dto.getPrice());
	 * entity.setImgUrl(dto.getImgUrl());
	 * 
	 * entity = repository.save(entity); // chamando a classe repository pra salvar
	 * no DB return new ProductDTO(entity); }
	 */

	// UpDate (Atualização de um objeto) Método com boas práticas ... Usa um metodo
	// auxiliar para chamar os atributos
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {

		Product entity = repository.getReferenceById(id); // instanciando um produto com a referencia do Id informado
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity); // chamando a classe repository pra salvar no DB
		return new ProductDTO(entity);
	}

	// metodo para buscar um elmento do banco pelo id (product) DELETANDO
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);

	}

	// Método auxiliar para chamar os atributos da Entity Product e direcionar para
	// DTO
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setPrice(dto.getPrice());
		entity.setImgUrl(dto.getImgUrl());

	}

}
