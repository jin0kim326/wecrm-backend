package com.douzone.wecrm.service;

import com.douzone.wecrm.controller.api.dto.UpdateCustomerDto;
import com.douzone.wecrm.domain.Customer;
import com.douzone.wecrm.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Transactional
    public Long registry(Customer customer) {
        customerRepository.save(customer);
        return customer.getId();
    }

    public Customer findCustomer(Long customerId){
        return customerRepository.find(customerId);
    }

    public List<Customer> listCustomers(){
        return customerRepository.findCustomers();
    }

    public List<Customer> searchCustomers(String searchParam) {
        List<Customer> customers = customerRepository.searchCustomers(searchParam);
        return customers;
    }

    @Transactional
    public Long update(Long customerId, UpdateCustomerDto updateCustomerDto) {
        Customer findCustomer = customerRepository.find(customerId);
        findCustomer.updateCustomer(updateCustomerDto);
        return findCustomer.getId();
    }
}
