package com.br.kafka.hexagonal.configs;

import com.br.kafka.hexagonal.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.kafka.hexagonal.adapters.out.FindByIdCustomerOutputAdapater;
import com.br.kafka.hexagonal.application.core.usecase.FindByIdCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindByIdCustomerConfig {
    @Bean
    public FindByIdCustomerUseCase findByIdCustomerUseCase(FindByIdCustomerOutputAdapater findByIdCustomerOutputAdapater,
                                                           FindAddressByZipCodeOutputAdapter findAddressByZipCodeOutputAdapter){
        return new FindByIdCustomerUseCase(findByIdCustomerOutputAdapater, findAddressByZipCodeOutputAdapter);
    }
}
