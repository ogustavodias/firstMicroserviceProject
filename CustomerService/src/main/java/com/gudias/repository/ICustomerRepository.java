package com.gudias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gudias.domain.Customer;

public interface ICustomerRepository extends MongoRepository<Customer, String> {

}
