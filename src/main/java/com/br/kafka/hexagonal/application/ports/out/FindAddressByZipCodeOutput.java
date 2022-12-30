package com.br.kafka.hexagonal.application.ports.out;

import com.br.kafka.hexagonal.application.core.model.Address;

public interface FindAddressByZipCodeOutput {
    Address findByZipCode(String zipCode);
}
