package com.br.kafka.hexagonal.application.ports.out;

import com.br.kafka.hexagonal.application.core.model.Customer;

public interface InsertCustomerOutputPort {
    Customer save(Customer customer);
}
