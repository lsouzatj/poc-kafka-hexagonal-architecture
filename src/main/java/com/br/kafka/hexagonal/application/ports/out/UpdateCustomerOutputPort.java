package com.br.kafka.hexagonal.application.ports.out;

import com.br.kafka.hexagonal.application.core.model.Customer;

import java.util.Optional;

public interface UpdateCustomerOutputPort {
    Optional<Customer> update(Customer customer);
}
