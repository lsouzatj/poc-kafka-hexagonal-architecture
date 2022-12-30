package com.br.kafka.hexagonal.adapters.out;

import com.br.kafka.hexagonal.adapters.out.repository.CustomerRepository;
import com.br.kafka.hexagonal.application.core.model.Customer;
import com.br.kafka.hexagonal.application.ports.out.FindByIdOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindByIdCustomerOutputAdapater implements FindByIdOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public Optional<Customer> findById(Long id) {
        var optionalCustomerEntity = customerRepository.findById(id);
        if (optionalCustomerEntity.isPresent()){
            Customer customer = new Customer();
            BeanUtils.copyProperties(optionalCustomerEntity.get(), customer);
            return Optional.of(customer);
        }
        return Optional.empty();
    }
}
