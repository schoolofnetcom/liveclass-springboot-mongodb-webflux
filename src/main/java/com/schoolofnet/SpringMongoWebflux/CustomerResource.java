package com.schoolofnet.SpringMongoWebflux;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/customers")
public class CustomerResource {

	@Autowired
	private CustomerRepository repository;
	
	public CustomerResource(CustomerRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping
	public Flux<Customer> findAll() {
		return this.repository.findAll();
	}
	
	@PostMapping
	@ResponseBody
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Customer> create(@RequestBody Customer customer) {
		return this.repository.save(customer);
	}
	
	@GetMapping("/{id}")
	public Mono<ResponseEntity<Customer>> findById(@PathVariable("id") String id) {		
		return this.repository.findById(id)
				.map(row -> ResponseEntity.ok(row))
				.defaultIfEmpty(ResponseEntity.notFound().build());
	}
}
