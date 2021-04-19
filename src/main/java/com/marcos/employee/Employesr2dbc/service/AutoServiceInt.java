package com.marcos.employee.Employesr2dbc.service;

import com.marcos.employee.Employesr2dbc.model.Auto;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AutoServiceInt {

	void create(Auto e);
    
    Mono<Auto> findById(Integer id);
 
    Flux<Auto> findByMarca(String name);
 
    Flux<Auto> findAll();
 
    Mono<Auto> update(Auto e);
 
    Mono<Void> delete(Integer id);
}
