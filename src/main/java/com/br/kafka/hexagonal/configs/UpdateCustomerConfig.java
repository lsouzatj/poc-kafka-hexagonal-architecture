package com.br.kafka.hexagonal.configs;

import com.br.kafka.hexagonal.adapters.out.SendKafkaCustomerOutputAdapter;
import com.br.kafka.hexagonal.adapters.out.UpdateCustomerOutputAdapter;
import com.br.kafka.hexagonal.application.core.usecase.FindByIdCustomerUseCase;
import com.br.kafka.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {
    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(UpdateCustomerOutputAdapter updateCustomerOutputAdapter,
                                                       FindByIdCustomerUseCase findByIdCustomerUseCase,
                                                       SendKafkaCustomerOutputAdapter sendKafkaCustomerOutputAdapter) {
        return new UpdateCustomerUseCase(updateCustomerOutputAdapter, findByIdCustomerUseCase, sendKafkaCustomerOutputAdapter);
    }
}
