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

import com.gudias.domain.Customer;
import com.gudias.usecase.RegisterCustomer;
import com.gudias.usecase.SearchCustomer;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/customer")
public class CustomerResource {

  private RegisterCustomer registerCustomer;
  private SearchCustomer searchCustomer;

  @Autowired
  public CustomerResource(RegisterCustomer registerCustomer, SearchCustomer searchCustomer) {
    this.registerCustomer = registerCustomer;
    this.searchCustomer = searchCustomer;
  }

  @GetMapping
  public ResponseEntity<Page<Customer>> search(Pageable pageable) {
    return ResponseEntity.ok(searchCustomer.search(pageable));
  }

  @PostMapping
  public ResponseEntity<Customer> register(@RequestBody @Valid Customer customer) {
    return ResponseEntity.ok(registerCustomer.register(customer));
  }

  @PutMapping
  public ResponseEntity<Customer> edit(@RequestBody @Valid Customer customer) {
    return ResponseEntity.ok(registerCustomer.edit(customer));
  }

}
