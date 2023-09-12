package com.devsuper.devsuper.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuper.devsuper.entities.Product;

// Dessa forma criamos responsavel pro DB de produc // parametrizacao tipo da entidade e do ID da entidade
// 
public interface ProductRepository extends JpaRepository<Product, Long> {

}
