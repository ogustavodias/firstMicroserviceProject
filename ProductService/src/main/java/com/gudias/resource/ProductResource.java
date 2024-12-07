package com.gudias.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gudias.domain.Product;
import com.gudias.usecase.RegisterProduct;
import com.gudias.usecase.SearchProduct;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/product")
public class ProductResource {

  private RegisterProduct registerProduct;
  private SearchProduct searchProduct;

  @Autowired
  public ProductResource(RegisterProduct registerProduct, SearchProduct searchProduct) {
    this.registerProduct = registerProduct;
    this.searchProduct= searchProduct;
  }

  @GetMapping
  public ResponseEntity<Page<Product>> search(Pageable pageable) {
    return ResponseEntity.ok(searchProduct.search(pageable));
  }

  @PostMapping
  public ResponseEntity<Product> register(@RequestBody @Valid Product product) {
    return ResponseEntity.ok(registerProduct.register(product));
  }

  @PutMapping
  public ResponseEntity<Product> edit(@RequestBody @Valid Product product) {
    return ResponseEntity.ok(registerProduct.edit(product));
  }

}
