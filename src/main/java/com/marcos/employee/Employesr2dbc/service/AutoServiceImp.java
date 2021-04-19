package com.marcos.employee.Employesr2dbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.employee.Employesr2dbc.model.Auto;
import com.marcos.employee.Employesr2dbc.repository.AutoRepository;

import lombok.Data;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@Data
public class AutoServiceImp implements AutoServiceInt{
	
	@Autowired
	private AutoRepository repository;
	

	@Override
	public void create(Auto a) {
		this.repository.save(a).subscribe();
		
	}

	@Override
	public Mono<Auto> findById(Integer id) {
		return this.repository.findById(id);
	}

	@Override
	public Flux<Auto> findByMarca(String name) {
		return repository.findByName(name);
	}

	@Override
	public Flux<Auto> findAll() {
		return this.repository.findAll();
	}

	@Override
	public Mono<Auto> update(Auto a) {
		return this.repository.save(a);
	}

	@Override
	public Mono<Void> delete(Integer id) {
		return this.repository.deleteById(id);
	}

}
