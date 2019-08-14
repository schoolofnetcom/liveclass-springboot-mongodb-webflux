package com.schoolofnet.SpringMongoWebflux;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CustomerRepository extends ReactiveCrudRepository<Customer, String> {

}
