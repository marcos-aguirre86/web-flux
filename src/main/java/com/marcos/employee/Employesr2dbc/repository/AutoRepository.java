package com.marcos.employee.Employesr2dbc.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.marcos.employee.Employesr2dbc.model.Auto;

import reactor.core.publisher.Flux;

public interface AutoRepository extends ReactiveMongoRepository<Auto, Integer>{
	@Query("{ 'marca': ?0 }")
    Flux<Auto> findByName(final String name);

}
