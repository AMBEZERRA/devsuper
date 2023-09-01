package com.devsuper.devsuper.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem {
	
	// Aqui a configuração dos geters e seters são diferentes, pois chamaremos as entidades e nao a classe 
	// auxiliar.
	
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
		
	}

	// No construtor padrao iremos trocar as entidades que serão chamadas atenção .. usaremos o ID pra setar
	
	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
			
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		
	}

}
