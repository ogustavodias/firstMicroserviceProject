package com.gudias.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gudias.domain.Product;
import com.gudias.repository.IProductRepository;

@Service
public class SearchProduct {

  private IProductRepository productRepository;

  @Autowired
  public SearchProduct(IProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Page<Product> search(Pageable pageable) {
    return this.productRepository.findAll(pageable);
  }

}
