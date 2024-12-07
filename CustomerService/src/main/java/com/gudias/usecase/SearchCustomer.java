package com.gudias.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gudias.domain.Customer;
import com.gudias.repository.ICustomerRepository;

@Service
public class SearchCustomer {

  private ICustomerRepository customerRepository;

  @Autowired
  public SearchCustomer(ICustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  public Page<Customer> search(Pageable pageable) {
    return this.customerRepository.findAll(pageable);
  }

}
