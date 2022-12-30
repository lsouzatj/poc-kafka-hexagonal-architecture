package com.br.kafka.hexagonal.adapters.out.clients;

import com.br.kafka.hexagonal.adapters.out.clients.response.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "FindAddressByZipCodeClient",
    url = "${clients.address.url}")
public interface FindAddressByZipCodeClient {

    @GetMapping("/{zipCode}/json/")
    AddressResponse findByZipCodeCorreios(@PathVariable("zipCode") String zipCode);
}
