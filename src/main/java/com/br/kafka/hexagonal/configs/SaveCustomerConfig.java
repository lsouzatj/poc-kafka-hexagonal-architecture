package com.br.kafka.hexagonal.configs;

import com.br.kafka.hexagonal.adapters.out.InsertCustomerOutputAdapter;
import com.br.kafka.hexagonal.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.kafka.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SaveCustomerConfig {
    @Bean
    InsertCustomerUseCase saveCustomerUseCase(InsertCustomerOutputAdapter saveCustomerOutputAdapter,
                                              FindAddressByZipCodeOutputAdapter FindAddressByZipCodeOutputAdapter){
        return new InsertCustomerUseCase(saveCustomerOutputAdapter, FindAddressByZipCodeOutputAdapter);
    }
}
