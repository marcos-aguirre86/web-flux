package com.marcos.employee.Employesr2dbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.marcos.employee.Employesr2dbc.model.Auto;
import com.marcos.employee.Employesr2dbc.service.AutoServiceInt;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AutosController {
	
	@Autowired
	private AutoServiceInt autoService;
	
	
	@PostMapping(value = { "/create", "/" }, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Auto e) {
		this.autoService.create(e);
    }
 
    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<Auto>> findById(@PathVariable("id") Integer id) {
        Mono<Auto> e = autoService.findById(id);
        HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return new ResponseEntity<Mono<Auto>>(e, status);
    }
 
    @GetMapping(value = "/name/{name}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Flux<Auto> findByName(@PathVariable("name") String name) {
        return autoService.findByMarca(name);
    }
 
    @GetMapping(value = "/all", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Auto> findAll() {
        Flux<Auto> emps = autoService.findAll();
        return emps;
    }
 
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Mono<Auto> update(@RequestBody Auto e) {
        return autoService.update(e);
    }
 
    @DeleteMapping(value = "/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Integer id) {
    	autoService.delete(id).subscribe();
    }

}
