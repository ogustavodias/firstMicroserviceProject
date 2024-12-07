package com.gudias.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gudias.domain.Customer;
import com.gudias.repository.ICustomerRepository;

import jakarta.validation.Valid;

@Service
public class RegisterCustomer {
  private ICustomerRepository customerRepository;

  @Autowired
  public RegisterCustomer(ICustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Customer register(@Valid Customer customer) {
    return this.customerRepository.insert(customer);
  }

  public Customer edit(@Valid Customer customer) {
    return this.customerRepository.save(customer);
  }

}
