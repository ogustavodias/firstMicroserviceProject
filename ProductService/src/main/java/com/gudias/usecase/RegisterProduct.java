package com.gudias.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudias.domain.Product;
import com.gudias.repository.IProductRepository;

import jakarta.validation.Valid;

@Service
public class RegisterProduct {
  private IProductRepository productRepository;

  @Autowired
  public RegisterProduct(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product register(@Valid Product product) {
    return this.productRepository.insert(product);
  }

  public Product edit(@Valid Product product) {
    return this.productRepository.save(product);
  }

}
