package com.br.kafka.hexagonal.application.ports.in;

import com.br.kafka.hexagonal.application.core.model.Customer;

import java.util.Optional;

public interface DeleteByIdCustomerInputPort {
    Optional<Customer> delete(Long id);
}
