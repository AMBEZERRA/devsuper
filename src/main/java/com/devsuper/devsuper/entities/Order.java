package com.devsuper.devsuper.entities;

import java.time.Instant;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// padrão da anotation uso do Instant
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	private OrderStatus status ;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client; // aqui já é o relaconamento muitos para 1.. as anotations acima é quem define isso
	
	public Order() {
		}
	
	
	
}