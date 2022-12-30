package com.br.kafka.hexagonal.application.ports.in;

import com.br.kafka.hexagonal.application.core.model.Customer;

public interface InsertCustomerInputPort {
    Customer save(Customer customer, String zipCode);
}
