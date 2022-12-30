package com.br.kafka.hexagonal.application.ports.out;

import com.br.kafka.hexagonal.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerOutputPort {
    List<Customer> findAll();
}
