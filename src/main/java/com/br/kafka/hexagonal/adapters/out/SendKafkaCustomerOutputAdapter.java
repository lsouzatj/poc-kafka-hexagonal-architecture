package com.br.kafka.hexagonal.adapters.out;

import com.br.kafka.hexagonal.adapters.out.producer.SendKafkaCustomer;
import com.br.kafka.hexagonal.application.core.model.Customer;
import com.br.kafka.hexagonal.application.ports.out.SendKafkaCustomerOuputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendKafkaCustomerOutputAdapter implements SendKafkaCustomerOuputPort {

    private final SendKafkaCustomer sendKafkaCustomer;

    @Override
    public void send(Customer customer) {
        sendKafkaCustomer.send(customer);
    }
}
