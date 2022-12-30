package com.br.kafka.hexagonal.adapters.in.controller.response;

import com.br.kafka.hexagonal.application.core.model.Address;
import lombok.Data;

@Data
public class CustomerResponse {
    private Long id;
    private String name;
    private String cpf;
    private String cep;
    private Address address;
}
