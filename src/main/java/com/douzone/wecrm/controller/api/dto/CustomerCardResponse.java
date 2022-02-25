package com.douzone.wecrm.controller.api.dto;

import com.douzone.wecrm.domain.Customer;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
public class CustomerCardResponse {
    private List<CustomerDto> customerDtos;

    public CustomerCardResponse(List<Customer> customers) {
        customerDtos = customers.stream().map(
                customer -> new CustomerDto(customer)
        ).collect(Collectors.toList());
    }
}
