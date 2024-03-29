package com.br.kafka.hexagonal.adapters.in.controller;

import com.br.kafka.hexagonal.adapters.in.controller.request.CustomerRequest;
import com.br.kafka.hexagonal.adapters.in.controller.response.CustomerResponse;
import com.br.kafka.hexagonal.application.core.model.Customer;
import com.br.kafka.hexagonal.application.ports.in.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final InsertCustomerInputPort insertCustomerInputPort;
    private final FindAllCustomerInputPort findAllCustomerInputPort;
    private final FindByIdCustomerInputPort findByIdCustomerInputPort;
    private final DeleteByIdCustomerInputPort deleteByIdCustomerInputPort;
    private final UpdateCustomerInputPort updateCustomerInputPort;

    @PostMapping("/save/{zipCode}")
    public ResponseEntity<CustomerResponse> save(@RequestBody CustomerRequest customerRequest,
                                                 @PathVariable("zipCode") String zipCode){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        var customerSaved = insertCustomerInputPort.save(customer, zipCode);
        return Optional.ofNullable(customerSaved).map((c) ->{
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(c, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<CustomerResponse>> findAll(){
        List<Customer> listCustomer = findAllCustomerInputPort.findAll();
        if (!listCustomer.isEmpty()){
            List<CustomerResponse> customerResponseList = listCustomer.stream()
                    .map(customer->{
                        CustomerResponse customerResponse = new CustomerResponse();
                        BeanUtils.copyProperties(customer, customerResponse);
                        return customerResponse;
                    })
                    .collect(Collectors.toList());
            return ResponseEntity.status(HttpStatus.OK).body(customerResponseList);
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<CustomerResponse> findById(@PathVariable("id") Long id) {
        return findByIdCustomerInputPort.findById(id).map(customer -> {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
                }
        ).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomerResponse> deleteById(@PathVariable("id") Long id){
        return deleteByIdCustomerInputPort.delete(id).map(customer -> {
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(customer, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<CustomerResponse> update(@RequestBody CustomerRequest customerRequest, @PathVariable("id") Long id){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerRequest, customer);
        return updateCustomerInputPort.update(customer, id).map(newCustomer ->{
            CustomerResponse customerResponse = new CustomerResponse();
            BeanUtils.copyProperties(newCustomer, customerResponse);
            return ResponseEntity.status(HttpStatus.OK).body(customerResponse);
        }).orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
    }
}
