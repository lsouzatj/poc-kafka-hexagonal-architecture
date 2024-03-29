package com.br.kafka.hexagonal.configs;

import com.br.kafka.hexagonal.adapters.out.FindAddressByZipCodeOutputAdapter;
import com.br.kafka.hexagonal.adapters.out.FindAllCustomerOutputAdapter;
import com.br.kafka.hexagonal.application.core.usecase.FindAllCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindAllCustomerConfig {
    @Bean
    public FindAllCustomerUseCase findAllCustomerUseCase(FindAllCustomerOutputAdapter findAllCustomerOutputAdapter,
                                                         FindAddressByZipCodeOutputAdapter findAddressByZipCodeOutputAdapter){
        return new FindAllCustomerUseCase(findAllCustomerOutputAdapter, findAddressByZipCodeOutputAdapter);
    }
}
