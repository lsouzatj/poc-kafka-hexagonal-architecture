package com.br.kafka.hexagonal.adapters.out;

import com.br.kafka.hexagonal.adapters.out.repository.CustomerRepository;
import com.br.kafka.hexagonal.application.core.model.Customer;
import com.br.kafka.hexagonal.application.ports.out.FindAllCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FindAllCustomerOutputAdapter implements FindAllCustomerOutputPort {
    private final CustomerRepository customerRepository;
    @Override
    public List<Customer> findAll() {
        var customerEntityList = customerRepository.findAll();
        List<Customer> customerList =
                customerEntityList.stream()
                        .map(customerEntityStream->{
                            Customer customer = new Customer();
                            BeanUtils.copyProperties(customerEntityStream, customer);
                            return customer;
                        })
                        .collect(Collectors.toList());
        return customerList;
    }
}
