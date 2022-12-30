package com.br.kafka.hexagonal.application.ports.out;

import com.br.kafka.hexagonal.application.core.model.Customer;

public interface DeleteByIdCustomOutputPort {
    void delete(Customer customer);
}
