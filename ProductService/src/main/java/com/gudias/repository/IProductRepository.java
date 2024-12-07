package com.gudias.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.gudias.domain.Product;

public interface IProductRepository extends MongoRepository<Product, String> {

}
