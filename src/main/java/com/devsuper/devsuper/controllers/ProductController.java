package com.devsuper.devsuper.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// o que for implementado nessa classe vai responder via web
@RestController
@RequestMapping(value = "/products") // responde via web nessa rota
public class ProductController {
	

	@GetMapping // mapeou a rota do products
	public String test() {
		return "olá mundo";
	}
}
