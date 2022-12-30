package com.br.kafka.hexagonal.adapters.in.controller.request;

import lombok.Data;
@Data
public class CustomerRequest {
    private String name;
    private String cpf;
}
