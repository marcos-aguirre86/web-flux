package com.marcos.employee.Employesr2dbc.model;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Scope(scopeName = "request", proxyMode = ScopedProxyMode.TARGET_CLASS) // Alcance de la misma, request indica se crea cuando se hace un request
@Document //Con esta anotacion, mongoDb identifica que es un dominio para persistir
@Data
public class Auto {
	
	@Id
	private int id;
	private String modelo;
	private String marca;
	

}
