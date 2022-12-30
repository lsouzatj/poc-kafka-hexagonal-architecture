package com.br.kafka.hexagonal.application.ports.in;

import com.br.kafka.hexagonal.application.core.model.Customer;

import java.util.List;

public interface FindAllCustomerInputPort {
    List<Customer> findAll();
}
