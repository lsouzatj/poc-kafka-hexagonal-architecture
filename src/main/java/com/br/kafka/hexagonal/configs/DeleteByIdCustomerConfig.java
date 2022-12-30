package com.br.kafka.hexagonal.configs;

import com.br.kafka.hexagonal.adapters.out.DeleteByIdCustomerOutputAdapter;
import com.br.kafka.hexagonal.application.core.usecase.DeleteByIdCustomerUserCase;
import com.br.kafka.hexagonal.application.core.usecase.FindByIdCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeleteByIdCustomerConfig {
    @Bean
    public DeleteByIdCustomerUserCase deleteByIdCustomerUserCase(DeleteByIdCustomerOutputAdapter deleteByIdCustomerOutputAdapter,
                                                                 FindByIdCustomerUseCase findByIdCustomerUseCase){
        return new DeleteByIdCustomerUserCase(deleteByIdCustomerOutputAdapter, findByIdCustomerUseCase);
    }
}
